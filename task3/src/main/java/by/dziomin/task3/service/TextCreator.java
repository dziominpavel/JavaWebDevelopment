package by.dziomin.task3.service;

import java.util.List;

public class TextCreator {

    public String concatLines(List<String> stringLines) {
        StringBuilder stringBuilder = new StringBuilder();
        stringLines.forEach(stringBuilder::append);
        String str = stringBuilder.toString();
        String[] d = str.split("\\u0009");
        int l = d.length - 1;
        System.out.println("абзацев: " + l);

        return stringBuilder.toString();

    }
}
