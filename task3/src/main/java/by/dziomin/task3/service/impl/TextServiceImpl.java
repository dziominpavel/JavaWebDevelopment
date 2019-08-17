package by.dziomin.task3.service.impl;

import by.dziomin.task3.exception.ServiceException;
import by.dziomin.task3.logic.DataReader;
import by.dziomin.task3.logic.SortType;
import by.dziomin.task3.logic.concatenater.Concatenator;
import by.dziomin.task3.logic.parser.ChainParser;
import by.dziomin.task3.logic.sorter.ComponentSorter;
import by.dziomin.task3.pojo.Component;
import by.dziomin.task3.pojo.impl.LeksemaComponent;
import by.dziomin.task3.pojo.impl.ParagraphComponent;
import by.dziomin.task3.pojo.impl.SentenceComponent;
import by.dziomin.task3.service.TextService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static by.dziomin.task3.constant.ProgramSettings.DEFAULT_TEXT_FILE_PATH;
import static by.dziomin.task3.pojo.ComponentType.PARAGRAPH;
import static by.dziomin.task3.pojo.ComponentType.SENTENCE;
import static by.dziomin.task3.pojo.ComponentType.TEXT;

public class TextServiceImpl implements TextService {
    private static TextService instance;

    private DataReader dataReader;
    private ChainParser chainParser;
    private ComponentSorter componentSorter;
    private Concatenator concatenator;

    private TextServiceImpl() {
        this.dataReader = DataReader.getInstance();
        this.chainParser = ChainParser.getInstance();
        this.componentSorter = ComponentSorter.getInstance();
        this.concatenator = Concatenator.getInstance();
    }

    public static TextService getInstance() {
        if (instance == null) {
            instance = new TextServiceImpl();
        }
        return instance;
    }

    @Override
    public Component readTextFromFile(final String pathString) {
        Path path = DEFAULT_TEXT_FILE_PATH;
        if (pathString != null && !pathString.isEmpty()) {
            path = Paths.get(pathString);
        }

        String text = dataReader.readFile(path);
        return chainParser.makeParse(text);
    }

    @Override
    public String concatenateText(final Component newComponent) {
        return concatenator.concatenateToString(newComponent);
    }

    @Override
    public Component sort(final String sortType, final Component text,
                          String... params) {
        SortType type = SortType.valueOf(sortType);

        switch (type) {
            case PARAGRAPHS_BY_SENTENCES_COUNT: {
                Comparator<ParagraphComponent> comparator =
                        Comparator.comparingInt(ParagraphComponent::getSentenceCount);
                return componentSorter.sortComponent(text, TEXT, comparator);
            }
            case WORDS_BY_WORD_LENGTH: {
                Comparator<LeksemaComponent> comparator =
                        Comparator.comparingInt(LeksemaComponent::getWordLength);
                return componentSorter.sortComponent(text, SENTENCE, comparator);
            }
            case SENTENCES_BY_WORD_COUNT: {
                Comparator<SentenceComponent> comparator =
                        Comparator.comparingInt(SentenceComponent::getWordCount);
                return componentSorter.sortComponent(text, PARAGRAPH, comparator);
            }
            case LEKSEMS_BY_SYMBOL_COUNT_DESC: {
                String compareSymbol = params[0];
                if (compareSymbol == null || compareSymbol.isEmpty()) {
                    throw new ServiceException("COMPARE_SYMBOL IS EMPTY");
                }
                Comparator<LeksemaComponent> firstComparator =
                        Comparator.comparingInt(c -> c.getSymbolCount(compareSymbol));

                Comparator<LeksemaComponent> secondComparator = (o1, o2) -> {
                    String str1 = concatenator.concatenateToString(o1);
                    String str2 = concatenator.concatenateToString(o2);
                    return str1.compareTo(str2);
                };

                return componentSorter.sortComponent(text, SENTENCE,
                        firstComparator.reversed().thenComparing(secondComparator));
            }
            default:
                throw new ServiceException("UNSUPPORTED_SORT_TYPE");
        }
    }

}
