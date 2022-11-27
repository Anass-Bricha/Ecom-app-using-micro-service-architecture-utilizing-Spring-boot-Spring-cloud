package org.sid.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.entites.ProductItem;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.models.Customer;

import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private String customerId;
    private List<ProductItemRequestDto> productItemRequestDtos;
}
