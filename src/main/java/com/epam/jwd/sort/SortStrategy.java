package com.epam.jwd.sort;

import com.epam.jwd.model.Text;

public class SortStrategy {

    private static SortStrategy instance;

    private SortStrategy() {
    }

    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public Text sort(Text text, SortType sortType) {
        return sortType.getSort().sort(text);
    }
}
