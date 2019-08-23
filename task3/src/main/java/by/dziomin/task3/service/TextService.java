package by.dziomin.task3.service;

import by.dziomin.task3.entity.Component;

/**
 * text dservice interface.
 */
public interface TextService {
    /**
     * method reads file and return text in Component type.
     * @param pathString path to file
     * @return component
     */
    Component readTextFromFile(String pathString);

    /**
     * method sorts components.
     * @param sortType sortType
     * @param newComponent newComponent
     * @param params params
     * @return sorted components
     */
    Component sort(String sortType, Component newComponent, String... params);

    String concatenateText(Component newComponent);
}
