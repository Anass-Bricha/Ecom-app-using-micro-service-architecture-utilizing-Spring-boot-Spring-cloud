package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.dto.ProductRequestDto;
import org.sid.inventoryservice.dto.ProductResponseDto;
import org.sid.inventoryservice.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductRestController {
    private ProductServices productServices;

    @GetMapping(path = "/products")
    public List<ProductResponseDto> products(){
        return productServices.products();
    }

    @GetMapping(path = "/products/{id}")
    public ProductResponseDto productById(@PathVariable String id){
        return productServices.productById(id);
    }

    @PostMapping(path = "/products")
    public ProductResponseDto save(@RequestBody ProductRequestDto productRequestDto){
        return productServices.save(productRequestDto);
    }
}
