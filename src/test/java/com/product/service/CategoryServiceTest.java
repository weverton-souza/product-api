package com.product.service;

import com.product.domain.Category;
import com.product.repository.ICategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
public class CategoryServiceTest {
    @Autowired
    private ICategoryRepository categoryRepository;
    private String categoryId;

    @Before
    public void prepareDataBaseToTests() {
        this.categoryRepository.deleteAll();

        for(int i = 1; i <= 5; i++) {
            Category category = new Category()
                    .setName("Category 00" + i)
                    .setDescription("Description Category 00" + i);
            Category categorySaved = this.categoryRepository.save(category);

            this.categoryId = categorySaved.getId();
        }
    }

    @Test
    public void saveTest() {
        Category category = new Category()
                .setName("Category - To Save")
                .setDescription("Description Category - To Save");
        Category categorySaved = this.categoryRepository.save(category);

        assertThat(categorySaved.getName()).isEqualTo(category.getName());
    }

    @Test
    public void updateTest() {
        Category category = new Category()
                .setName("Category - To Update")
                .setDescription("Description Category - To Update");
        Category categoryToUpdate = this.categoryRepository.save(category);

        categoryToUpdate.setName("Category 001 - To Modification");
        Category CategoryUpdated = this.categoryRepository.save(categoryToUpdate);
        assertThat(CategoryUpdated.getName()).isEqualTo("Category 001 - To Modification");
    }

    @Test
    public void findAllTest() {
        List<Category> categories = this.categoryRepository.findAll();
        assertThat(categories.size()).isGreaterThanOrEqualTo(5);
    }

    @Test
    public void findByIdTest() {
        Optional<Category> categoryOpt = this.categoryRepository.findById(this.categoryId);
        assertThat(categoryOpt).isPresent();
    }

    @Test
    public void deleteTest() {
        Optional<Category> categoryOpt = this.categoryRepository.findById(this.categoryId);
        assertThat(categoryOpt).isPresent();

        categoryOpt.ifPresent(product -> this.categoryRepository.delete(product));

        Optional<Category> productOptAfterDelete = this.categoryRepository.findById(this.categoryId);
        assertThat(productOptAfterDelete).isNotPresent();
    }

}
