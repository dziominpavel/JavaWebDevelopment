package by.dziomin.task3.service;

import by.dziomin.task3.entity.Component;

public interface TextService {

    Component readTextFromFile(String pathString);

    Component sort(String sortType, Component newComponent, String... params);

    String concatenateText(Component newComponent);
}
