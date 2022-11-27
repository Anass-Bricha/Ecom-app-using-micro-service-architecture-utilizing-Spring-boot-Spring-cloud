package org.sid.inventoryservice.mapper;

import org.mapstruct.Mapper;
import org.sid.inventoryservice.dto.ProductRequestDto;
import org.sid.inventoryservice.dto.ProductResponseDto;
import org.sid.inventoryservice.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromProductRequestDto(ProductRequestDto productRequestDto);
    ProductResponseDto fromProduct(Product product);
}
