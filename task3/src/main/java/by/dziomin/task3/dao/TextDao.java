package by.dziomin.task3.dao;

import by.dziomin.task3.entity.Text;

public interface TextDao {

    void saveText(Text text);

    Text getText();
}
