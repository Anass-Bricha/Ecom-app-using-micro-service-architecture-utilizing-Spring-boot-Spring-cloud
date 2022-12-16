package org.sid.orderservice.repositories;

import org.sid.orderservice.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findByCustomerId(String customerId);
}
