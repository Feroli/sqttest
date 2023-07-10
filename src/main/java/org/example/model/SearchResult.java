package org.example.model;

import java.util.List;

public class SearchResult {

    private final Integer level;
    private final String categoryName;
    private final List<String> keywords;

    public SearchResult(Integer level, String categoryName, List<String> keywords) {

        this.level = level;
        this.categoryName = categoryName;
        this.keywords = keywords;
    }

    public Integer getLevel() {
        return level;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
