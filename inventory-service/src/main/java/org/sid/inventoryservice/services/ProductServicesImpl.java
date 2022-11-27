package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.dto.ProductRequestDto;
import org.sid.inventoryservice.dto.ProductResponseDto;
import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.exceptions.ProductNotFoundException;
import org.sid.inventoryservice.mapper.ProductMapper;
import org.sid.inventoryservice.repositories.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProductServicesImpl implements ProductServices {
    private ProductRepo productRepo;
    private ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> products() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(p->productMapper.fromProduct(p)).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto productById(String id) {
        Product product = productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
        return productMapper.fromProduct(product);
    }

    @Override
    public ProductResponseDto save(ProductRequestDto productRequestDto) {
        Product product = productMapper.fromProductRequestDto(productRequestDto);
        product.setId(UUID.randomUUID().toString());
        Product savedProduct = productRepo.save(product);
        return productMapper.fromProduct(savedProduct);
    }

    @Override
    public ProductResponseDto update(ProductRequestDto productRequestDto) {
        Product product = productMapper.fromProductRequestDto(productRequestDto);
        Product savedProduct = productRepo.save(product);
        return productMapper.fromProduct(savedProduct);
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }
}
