package com.product.service;

import com.product.domain.Category;
import com.product.domain.Product;
import com.product.dto.ProductDTO;
import com.product.repository.ICategoryRepository;
import com.product.repository.IProductRepository;
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
public class ProductServiceTest {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    private String productId;

    @Before
    public void prepareDataBaseToTests() {
        this.productRepository.deleteAll();
        this.categoryRepository.deleteAll();

        for(int i = 1; i <= 5; i++) {
            Category category = new Category()
                    .setName("Category 00" + i)
                    .setDescription("Description Category 00" + i);
            Category categorySaved = this.categoryRepository.save(category);

            Product product = new Product()
                    .setName("Product 00" + i)
                    .setDescription("Description Product 00" + i)
                    .setCategory(this.categoryRepository.save(categorySaved));
            Product productSaved = this.productRepository.save(product);
            this.productId = productSaved.getId();
        }
    }

    @Test
    public void saveTest() {
        Category category = new Category()
                .setName("Category - To Save")
                .setDescription("Description Category - To Save");
        Category categorySaved = this.categoryRepository.save(category);

        Product product = new Product()
                .setName("Product 001 - To Save")
                .setDescription("Description Product 001 - To Save")
                .setCategory(categorySaved);

        Product productSaved =  this.productRepository.save(product);

        assertThat(productSaved.getName()).isEqualTo(product.getName());
    }

    @Test
    public void updateTest() {
        Category category = new Category()
                .setName("Category - To Update")
                .setDescription("Description Category - To Update");
        Category categorySaved = this.categoryRepository.save(category);

        Product product = new Product()
                .setName("Product 001 - To Save")
                .setDescription("Description Product 001 - To Update")
                .setCategory(categorySaved);

        Product productToUpdate =  this.productRepository.save(product);
        productToUpdate.setName("Product 001 - To Modification");

        Product productUpdated = this.productRepository.save(productToUpdate);
        assertThat(productUpdated.getName()).isEqualTo("Product 001 - To Modification");
    }

    @Test
    public void findAllTest() {
        List<Product> products = this.productRepository.findAll();
        assertThat(products.size()).isGreaterThanOrEqualTo(5);
    }

    @Test
    public void findByIdTest() {
        Optional<Product> productOpt = this.productRepository.findById(this.productId);
        assertThat(productOpt).isPresent();
    }

    @Test
    public void deleteTest() {
        Optional<Product> productOpt = this.productRepository.findById(this.productId);
        assertThat(productOpt).isPresent();

        productOpt.ifPresent(product -> this.productRepository.delete(product));

        Optional<Product> productOptAfterDelete = this.productRepository.findById(this.productId);
        assertThat(productOptAfterDelete).isNotPresent();
    }

    @Test
    public void findByDescriptionContainingTest() {
        List<ProductDTO> products = this.productRepository.findByDescriptionContaining("ct 00");
        assertThat(products.size()).isGreaterThanOrEqualTo(5);
    }
}
