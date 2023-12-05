package com.juan.mappear.mapper;

import com.juan.mappear.dto.ProductDto;
import com.juan.mappear.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    @Mappings( value = {
        @Mapping(source = "productEntity.idProduct", target = "idProduct"),
        @Mapping(source = "productEntity.name", target = "name"),
        @Mapping(source = "productEntity.category", target = "category"),
        @Mapping(source = "productEntity.barCode", target = "barCode"),
        @Mapping(source = "productEntity.priceSale", target = "priceSale"),
        @Mapping(source = "productEntity.quantityStock", target = "quantityStock")
    })
    ProductDto productEntityToProductDto(ProductEntity productEntity);
}
