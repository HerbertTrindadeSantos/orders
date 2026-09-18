package com.buildingdev.tools.repositories;

import com.buildingdev.tools.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
