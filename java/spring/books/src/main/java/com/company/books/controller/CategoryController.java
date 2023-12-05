package com.company.books.controller;

import com.company.books.models.Category;
import com.company.books.response.category.ResponseCategoryRestCategory;
import com.company.books.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<ResponseCategoryRestCategory> findAllCategory() {
        return iCategoryService.findAllCategory();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseCategoryRestCategory> findByIdCategory(@PathVariable("id") Long idCategory) {
        return iCategoryService.findById(idCategory);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseCategoryRestCategory> createCategory(@RequestBody Category responseCategoryRest) {
        return iCategoryService.saveCategory(responseCategoryRest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseCategoryRestCategory> updateCategory(@RequestBody Category category, @PathVariable("id") Long idCategory) {
        return iCategoryService.updateCategory(category, idCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseCategoryRestCategory> deleteByCategory(@PathVariable("id") Long idCategory) {
        return iCategoryService.deleteByCategory(idCategory);
    }
}
