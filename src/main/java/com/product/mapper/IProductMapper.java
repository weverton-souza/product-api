package com.product.mapper;

import com.product.domain.Product;
import com.product.dto.ProductDTO;
import com.product.interfaces.IDomainMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IProductMapper extends IDomainMapper<Product, ProductDTO> {
    @Override
    ProductDTO toDTO(final Product domain);
    @Override
    Product toDomain(final ProductDTO dto);
    @Override
    List<ProductDTO> toPageDTO(final List<Product> items);
}
