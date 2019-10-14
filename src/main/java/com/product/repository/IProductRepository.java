package com.product.repository;

import com.product.domain.Product;
import com.product.dto.ProductDTO;
import com.product.interfaces.IRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends IRepository<Product, String> {
    List<ProductDTO> findByDescriptionContaining(@Param("description") final String param);
}
