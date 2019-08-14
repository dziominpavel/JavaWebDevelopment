package by.dziomin.task3.dao;

import by.dziomin.task3.entity.Storage;
import by.dziomin.task3.entity.Text;

/**
 * Dao implementation.
 */
public class TextDaoImpl implements TextDao {
    /**
     * storage instance.
     */
    Storage storage = Storage.getInstance();

    /**
     * save text to storage.
     * @param text text
     */
    @Override
    public void saveText(final Text text) {

    }

    /**
     * get text from storage.
     * @return Text text.
     */
    @Override
    public Text getText() {
        return storage.getText();
    }
}
