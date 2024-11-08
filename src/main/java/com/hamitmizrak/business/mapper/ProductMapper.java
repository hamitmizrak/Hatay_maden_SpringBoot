package com.hamitmizrak.business.mapper;

import com.hamitmizrak.business.dto.ProductDto;
import com.hamitmizrak.data.entity.ProductEntity;

public class ProductMapper {

    // Customer Entity To Dto
    public static ProductDto ProductEntityToDto(ProductEntity productEntity) {
        // Instance (CustomerDto)
        ProductDto productDto = new ProductDto();

        // ID
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setCode(productEntity.getCode());
        return productDto;
    }

    // Customer Dto To Entity
    public static ProductEntity ProductDtoToEntity(ProductDto productDto) {
        // Instance (CustomerDto)
        ProductEntity productEntity = new ProductEntity();

        // ID
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setCode(productDto.getCode());

        // DİKKAT: Composition (Order(N) - Product(M))
        return productEntity;
    }
}
