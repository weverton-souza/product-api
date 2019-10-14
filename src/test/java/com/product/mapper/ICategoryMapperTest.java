package com.product.mapper;

import com.product.domain.Category;
import com.product.dto.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
public class ICategoryMapperTest {
    @Autowired
    private ICategoryMapper categoryMapper;

    @Test
    public void toDTOTest() {
        Category category = new Category()
                .setName("Category 001")
                .setDescription("Category 001 | Description");

        CategoryDTO categoryDTO = this.categoryMapper.toDTO(category);
        assertThat(categoryDTO.getName()).isEqualTo(category.getName());
    }

    @Test
    public void toDomainTest() {
        CategoryDTO categoryDTO = new CategoryDTO()
                .setName("Category 001")
                .setDescription("Category 001 | Description");

        Category category = this.categoryMapper.toDomain(categoryDTO);
        assertThat(category.getName()).isEqualTo(categoryDTO.getName());
    }

    @Test
    public void toPageDTOTest() {
        List<Category> categories = Collections.singletonList(
                new Category()
                        .setName("Category 001")
                        .setDescription("Category 001 | Description"));

        List<CategoryDTO> categoryDTOS = this.categoryMapper.toPageDTO(categories);
        assertThat(categoryDTOS.size()).isGreaterThanOrEqualTo(1);
    }
}
