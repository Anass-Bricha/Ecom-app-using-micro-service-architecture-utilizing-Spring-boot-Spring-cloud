package org.sid.orderservice.repositories;

import org.sid.orderservice.entites.Order;
import org.sid.orderservice.entites.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepo extends JpaRepository<Order,Long> {
}
