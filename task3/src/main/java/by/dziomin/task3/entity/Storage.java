package by.dziomin.task3.entity;

/**
 * storage class.
 */
public class Storage {
    /**
     * instance field.
     */
    private static Storage instance;
    /**
     * Text field.
     */
    private Text text;

    /**
     * default constructor.
     */
    private Storage() {
    }

    /**
     * get instance method.
     *
     * @return Storage instance.
     */
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    /**
     * get method for text field.
     *
     * @return Text
     */
    public Text getText() {
        return text;
    }

    /**
     * se method for text field.
     *
     * @param newText new text
     */
    public void setText(final Text newText) {
        text = newText;
    }
}
