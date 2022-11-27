package org.sid.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.entites.Order;
import org.sid.orderservice.models.Product;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProductItemResponseDto {
    private Product product;
    private double price;
    private int quantity;
    private double discount;
}
