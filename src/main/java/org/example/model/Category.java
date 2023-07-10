package org.example.model;

import java.util.List;

public class Category {

    private final String name;
    private final List<String> keyWords;
    private final List<Category> subCategories;

    private Category parent;

    public Category(String name, List<String> keywords, List<Category> subCategories) {
        this.name = name;
        this.keyWords = keywords;
        this.subCategories = subCategories;
    }


    public String getName() {
        return name;
    }
    public List<String> getKeywords() {
        return keyWords;
    };
    public List<Category> getSubCategories() {
        return subCategories;
    };

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public int getLevel() {
        if (parent == null) {
            return 0;
        } else {
            return parent.getLevel() + 1;
        }
    }

}
