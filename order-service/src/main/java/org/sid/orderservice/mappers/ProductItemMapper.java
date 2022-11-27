package org.sid.orderservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sid.orderservice.dto.ProductItemRequestDto;
import org.sid.orderservice.dto.ProductItemResponseDto;
import org.sid.orderservice.entites.ProductItem;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    ProductItemResponseDto fromProductItem(ProductItem productItem);
    /*@Mapping(target = "quantity",source = "quantity")
    @Mapping(target = "discount",source = "discount")*/
    ProductItem fromProductItemRequestDto(ProductItemRequestDto productItemRequestDto);
}
