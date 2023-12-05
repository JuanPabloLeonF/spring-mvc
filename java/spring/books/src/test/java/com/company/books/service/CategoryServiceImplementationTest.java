package com.company.books.service;

import com.company.books.models.Category;
import com.company.books.repository.ICategoryRepository;
import com.company.books.response.category.ResponseCategoryRestCategory;
import com.company.books.service.category.CategoryServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryServiceImplementationTest {
    @Mock
    ICategoryRepository iCategoryRepository;

    @InjectMocks
    CategoryServiceImplementation categoryServiceImplementation;

    List<Category> categoryList = new ArrayList<>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.cargarCategories();
    }

    @Test
    public void findAllCategoryTest() {
        when(iCategoryRepository.findAll()).thenReturn(categoryList);

        ResponseEntity<ResponseCategoryRestCategory> response = categoryServiceImplementation.findAllCategory();

        assertEquals(3, response.getBody().getResponseCategory().getCategoryList().size());

        verify(iCategoryRepository, times(1)).findAll();
    }

    public void cargarCategories() {
        Category category = new Category(Long.valueOf(1), "Frutas", "Tienda de cecilia");
        Category category2 = new Category(Long.valueOf(2), "Musica", "Rock");
        Category category3 = new Category(Long.valueOf(3), "Lacteos", "variedad de lacteos");

        categoryList.add(category);
        categoryList.add(category2);
        categoryList.add(category3);
    }
}
