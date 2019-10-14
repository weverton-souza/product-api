package com.product.mapper;

import com.product.domain.Category;
import com.product.domain.Product;
import com.product.dto.CategoryDTO;
import com.product.dto.ProductDTO;
import com.product.interfaces.IDomainMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ICategoryMapper extends IDomainMapper<Category, CategoryDTO> {
    @Override
    CategoryDTO toDTO(final Category domain);
    @Override
    Category toDomain(final CategoryDTO dto);
    @Override
    List<CategoryDTO> toPageDTO(final List<Category> items);
}
