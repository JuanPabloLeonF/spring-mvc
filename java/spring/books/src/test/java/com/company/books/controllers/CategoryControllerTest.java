package com.company.books.controllers;

import com.company.books.controller.CategoryController;
import com.company.books.models.Category;
import com.company.books.response.category.ResponseCategoryRestCategory;
import com.company.books.service.category.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {

    @Mock
    private ICategoryService iCategoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createCategoryTest() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Category category = new Category(Long.valueOf(1), "Clasicos", "libros clasicos de historia");

        when(iCategoryService.saveCategory(any(category.getClass()))).thenReturn(new
                ResponseEntity<ResponseCategoryRestCategory>(HttpStatus.OK));

        ResponseEntity<ResponseCategoryRestCategory> response = categoryController.createCategory(category);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
