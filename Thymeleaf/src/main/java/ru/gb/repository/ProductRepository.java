package ru.gb.repository;


import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import ru.gb.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}
