package org.example.service;

import org.example.model.Category;
import org.example.model.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class SearchEngineServiceTest {


    private SearchEngineService searchEngineService;

    @BeforeEach
    public void setUp() {
        List<Category> categories = new ArrayList<>();


        Category minorAppliances = new Category("Minor Appliances", Collections.emptyList(), Collections.emptyList());
        Category majorAppliances = new Category("Major Appliances", List.of("washing machine"), List.of(minorAppliances));
        Category homeAppliances = new Category("Home Appliances", List.of("Garage machine"), List.of(majorAppliances));

        Category lawnSmallAppliances = new Category("Small Appliances", Collections.emptyList(), Collections.emptyList());
        Category lawnBigAppliances = new Category("Big Appliances", List.of("Grass cutter"), List.of(lawnSmallAppliances));
        Category lawnAppliances = new Category("Lawn Appliances", Collections.emptyList(), List.of(lawnBigAppliances));

        categories.add(new Category("Root", List.of("root"), List.of(homeAppliances, lawnAppliances)));


        searchEngineService = new SearchEngineService(categories);

    }


    @Test
    void findCategoryRootWithKeywords() {
        SearchResult searchResult = searchEngineService.findCategory("Root");
        assertEquals("Root", searchResult.getCategoryName());
        assertLinesMatch(List.of("root"), searchResult.getKeywords());
    }

    @Test
    void findFirstLevelNodeWithKeywords() {
        SearchResult searchResult = searchEngineService.findCategory("Home Appliances");
        assertEquals("Home Appliances", searchResult.getCategoryName());
        assertLinesMatch(List.of("Garage machine"), searchResult.getKeywords());
    }

    @Test
    void findFirstLevelNodeMissingKeywords() {
        SearchResult searchResult = searchEngineService.findCategory("Lawn Appliances");
        assertEquals("Lawn Appliances", searchResult.getCategoryName());
        assertLinesMatch(List.of("root"), searchResult.getKeywords());
    }

    @Test
    void findSecondLevelNodeWithKeywords() {
    }

    @Test
    void findSecondLevelNodeMissingKeywords() {
    }

}