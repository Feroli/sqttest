package org.example.service;

import org.example.model.Category;
import org.example.model.SearchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will be used to go to a specific category
 */


/**
 * Busqueda de categories, y retornamos lo que econtramos (keywords)
 */
public class SearchEngineService {

    private final List<Category> categories;

    public SearchEngineService(List<Category> categories) {
        this.categories = categories;
    }


    public SearchResult findCategory(String categoryName) {
        for (int i = 0; i <= categories.size() - 1; i++) {

            if (categoryName.equals(categories.get(i).getName())) {
                String currentCategoryName = categories.get(i).getName();
                if (categories.get(i).getKeywords().isEmpty()) {
                    while (i != 0) {
                        i = i - 1;
                        if (!categories.get(i).getKeywords().isEmpty()) {
                            return new SearchResult(i, currentCategoryName, categories.get(i).getKeywords());
                        }
                    }
                    return new SearchResult(0, currentCategoryName, categories.get(0).getKeywords());
                }

            } else {
                List<Category> subCategories = categories.get(i).getSubCategories();
                for (int j = 0; j <= subCategories.size() - 1; j++) {

                    if (categoryName.equals(subCategories.get(j).getName())) {
                        String currentCategoryName = subCategories.get(j).getName();

                        if (subCategories.get(j).getKeywords().isEmpty()) {
                            while (i != 0) {
                                i = i - 1;
                                if (!categories.get(i).getKeywords().isEmpty()) {
                                    return new SearchResult(j, currentCategoryName, categories.get(i).getKeywords());
                                }
                            }
                            return new SearchResult(1, currentCategoryName, categories.get(0).getKeywords());

                        } else {
                            return new SearchResult(j, currentCategoryName, subCategories.get(j).getKeywords());
                        }
                    }
                }

            }
        }

        return new SearchResult(0, categories.get(0).getName(), categories.get(0).getKeywords());
    }
}
