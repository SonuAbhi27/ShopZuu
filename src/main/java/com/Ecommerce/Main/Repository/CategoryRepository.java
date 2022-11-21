package com.Ecommerce.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Main.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{
	
}
