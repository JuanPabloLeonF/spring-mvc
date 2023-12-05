package com.company.books.service.category;

import com.company.books.models.Category;
import com.company.books.repository.ICategoryRepository;
import com.company.books.response.category.ResponseCategoryRestCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements ICategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImplementation.class);

    @Autowired
    private ICategoryRepository iCategoryRepository;

    public CategoryServiceImplementation(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseCategoryRestCategory> findAllCategory() {
        log.info("Inicio del metodo findAllCategory");

        ResponseCategoryRestCategory responseCategoryRest = new ResponseCategoryRestCategory();
        try {
            List<Category> categoryList = iCategoryRepository.findAll();
            responseCategoryRest.getResponseCategory().setCategoryList(categoryList);
            responseCategoryRest.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
        } catch (Exception e) {
            log.error("Error al consultar categorías: ", e.getMessage());
            responseCategoryRest.setMetaData("Respuesta nok", "-1", "Error al consultar categorias");
            e.getStackTrace();
            return new ResponseEntity<>(responseCategoryRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseCategoryRest, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseCategoryRestCategory> findById(Long idCategory) {
        log.info("Inici del metodo findById");
        ResponseCategoryRestCategory responseCategoryRest = new ResponseCategoryRestCategory();
        List<Category> categoryList = new ArrayList<>();

        try {
            Optional<Category> category = iCategoryRepository.findById(idCategory);
            if (category.isPresent()) {
                categoryList.add(category.get());
                responseCategoryRest.getResponseCategory().setCategoryList(categoryList);
                responseCategoryRest.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
            } else {
                log.error("Error en la consulta categoria");
                responseCategoryRest.setMetaData("Respuesta nok", "-1", "Categoria no encontrada");
                return new ResponseEntity<>(responseCategoryRest, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error en la consulta categoria", e.getMessage());
            responseCategoryRest.setMetaData("Respuesta nok", "-1", "Error al consultar la categoria");
            return new ResponseEntity<>(responseCategoryRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseCategoryRest, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<ResponseCategoryRestCategory> saveCategory(Category category) {
        log.info("Inicio del metodo saveCategory");
        ResponseCategoryRestCategory response = new ResponseCategoryRestCategory();
        List<Category> categoryList = new ArrayList<>();
        try {
            Category categorySave = iCategoryRepository.save(category);
            categoryList.add(categorySave);
            response.getResponseCategory().setCategoryList(categoryList);
            response.setMetaData("Respuesta CREATE", "00", "Se creo la categoria correctamente");
        } catch (Exception e) {
            log.error("Error al crear una categoria", e.getMessage());
            response.setMetaData("Respuesta noCreate", "-2", "Error al crear la categoria");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<ResponseCategoryRestCategory> updateCategory(Category category, Long idCategory) {
        log.info("Inicio del metodo updateCategory");
        ResponseCategoryRestCategory response = new ResponseCategoryRestCategory();
        List<Category> categoryList = new ArrayList<>();
        try {
            Optional<Category> categoryFind = iCategoryRepository.findById(idCategory);
            if (categoryFind.isPresent()) {
                categoryFind.get().setName(category.getName());
                categoryFind.get().setDescription(category.getDescription());
                Category categoryUpdate = iCategoryRepository.save(categoryFind.get());
                categoryList.add(categoryUpdate);
                response.getResponseCategory().setCategoryList(categoryList);
                response.setMetaData("Respuesta UPDATE", "00", "Se actualizo la categoria correctamente");
            } else {
                log.error("Error al actualizar una categoria");
                response.setMetaData("Respuesta noUpdate", "-3", "Error al actualizar la categoria");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("Error al actualizar una categoria", e.getMessage());
            response.setMetaData("Respuesta noUpdate", "-3", "Error al actualizar la categoria");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<ResponseCategoryRestCategory> deleteByCategory(Long idCategory) {
        log.info("Inicio del metodo deleteByCategory");
        ResponseCategoryRestCategory response = new ResponseCategoryRestCategory();
        List<Category> categoryList = new ArrayList<>();

        try {
            iCategoryRepository.deleteById(idCategory);
            response.setMetaData("Respuesta DELETE", "00", "Se elimino la categoria correctamente");
        } catch (Exception e) {
            log.error("Error al eliminar una categoria", e.getMessage());
            response.setMetaData("Respuesta noDelete", "-4", "Error al eliminar la categoria");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
