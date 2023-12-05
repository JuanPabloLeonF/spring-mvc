package com.company.books.response.category;

public class ResponseCategoryRestCategory extends ResponseRestCategory {
    private ResponseCategory responseCategory = new ResponseCategory();

    public ResponseCategory getResponseCategory() {
        return responseCategory;
    }

    public void setResponseCategory(ResponseCategory responseCategory) {
        this.responseCategory = responseCategory;
    }
}
