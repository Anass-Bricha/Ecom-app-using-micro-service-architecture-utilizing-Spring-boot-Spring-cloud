package org.sid.inventoryservice.services;

import org.sid.inventoryservice.dto.ProductRequestDto;
import org.sid.inventoryservice.dto.ProductResponseDto;

import java.util.List;

public interface ProductServices {
    List<ProductResponseDto> products();
    ProductResponseDto productById(String id);
    ProductResponseDto save(ProductRequestDto productRequestDto);
    ProductResponseDto update(ProductRequestDto productRequestDto);
    void delete(String id);
}
