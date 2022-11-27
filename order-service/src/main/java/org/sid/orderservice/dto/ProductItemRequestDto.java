package org.sid.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.entites.Order;
import org.sid.orderservice.models.Product;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemRequestDto {
    private String productId;
    private int quantity;
    private double discount;

}
