package com.api.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Byte> {

}
