package com.product.repository;

import com.product.domain.Category;
import com.product.interfaces.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends IRepository<Category, String> {
}
