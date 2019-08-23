package by.dziomin.task3.service.impl;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.LeksemaComponent;
import by.dziomin.task3.entity.impl.ParagraphComponent;
import by.dziomin.task3.entity.impl.SentenceComponent;
import by.dziomin.task3.service.exception.ServiceException;
import by.dziomin.task3.service.DataReader;
import by.dziomin.task3.service.SortType;
import by.dziomin.task3.service.TextService;
import by.dziomin.task3.service.concatenater.Concatenator;
import by.dziomin.task3.service.parser.ChainParser;
import by.dziomin.task3.service.sorter.ComponentSorter;

import java.util.Comparator;

import static by.dziomin.task3.entity.ComponentType.PARAGRAPH;
import static by.dziomin.task3.entity.ComponentType.SENTENCE;
import static by.dziomin.task3.entity.ComponentType.TEXT;

/**
 * text service implementation class.
 */
public final class TextServiceImpl implements TextService {
    /**
     * instance field.
     */
    private static TextService instance;
    /**
     * dataReader field.
     */
    private DataReader dataReader;
    /**
     * chain parcer field.
     */
    private ChainParser chainParser;
    /**
     * component sorter field.
     */
    private ComponentSorter componentSorter;
    /**
     * concatenator field.
     */
    private Concatenator concatenator;

    /**
     * constructor.
     */
    private TextServiceImpl() {
        this.dataReader = DataReader.getInstance();
        this.chainParser = ChainParser.getInstance();
        this.componentSorter = ComponentSorter.getInstance();
        this.concatenator = Concatenator.getInstance();
    }

    /**
     * get instance method.
     * @return instance.
     */
    public static TextService getInstance() {
        if (instance == null) {
            instance = new TextServiceImpl();
        }
        return instance;
    }

    /**
     * method run chain for parsing text.
     * @param pathString
     * @return
     */
    @Override
    public Component readTextFromFile(final String pathString) {
        String text = dataReader.readFile();
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
                if (params == null || params.length == 0 || params[0].isEmpty()) {
                    throw new ServiceException("COMPARE_SYMBOL_IS_EMPTY");
                }
                String compareSymbol = params[0];
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
