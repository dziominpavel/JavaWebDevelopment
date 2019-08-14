package by.dziomin.task3.compostite;

public interface Component {
    void add(Component newComponent);

    Component getChild(int numberComponent);

    void operation();

    void remove (Component newComponent);


}
