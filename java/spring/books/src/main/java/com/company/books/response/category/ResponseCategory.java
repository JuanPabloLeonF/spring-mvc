package com.company.books.response.category;

import com.company.books.models.Category;

import java.util.List;

public class ResponseCategory {

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
