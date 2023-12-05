package com.company.books.service.category;



import com.company.books.models.Category;
import com.company.books.response.category.ResponseCategoryRestCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {

    ResponseEntity<ResponseCategoryRestCategory> findAllCategory();
    ResponseEntity<ResponseCategoryRestCategory> findById(Long idCategory);
    ResponseEntity<ResponseCategoryRestCategory> saveCategory(Category category);
    ResponseEntity<ResponseCategoryRestCategory> updateCategory(Category category, Long idCategory);
    ResponseEntity<ResponseCategoryRestCategory> deleteByCategory(Long idCategory);
}
