package com.product.service;

import com.product.abstracts.AbstractService;
import com.product.dto.ProductDTO;
import com.product.repository.IProductRepository;
import com.product.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<ProductDTO, String> {
    @Autowired
    public ProductServiceImpl(IProductRepository repository, IProductMapper mapper) {
        super(repository, mapper);
    }
}