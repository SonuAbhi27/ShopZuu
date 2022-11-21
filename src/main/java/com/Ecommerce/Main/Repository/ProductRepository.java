package com.Ecommerce.Main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Main.Model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    
	List<Product> findAllByCategory_Id(int id);
}
