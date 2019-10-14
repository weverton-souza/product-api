package com.product.mapper;

import com.product.domain.Product;
import com.product.dto.ProductDTO;
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
public class IProductMapperTest {
    @Autowired
    private IProductMapper productMapper;

    @Test
    public void toDTOTest() {
        Product product = new Product()
                .setName("Product 001")
                .setCategory(null)
                .setDescription("Product 001 | Description");

        ProductDTO productDTO = this.productMapper.toDTO(product);
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }

    @Test
    public void toDomainTest() {
        ProductDTO productDTO = new ProductDTO()
                .setName("Product 001")
                .setCategory(null)
                .setDescription("Product 001 | Description");

        Product product = this.productMapper.toDomain(productDTO);
        assertThat(product.getName()).isEqualTo(productDTO.getName());
    }

    @Test
    public void toPageDTOTest() {
        List<Product> products = Collections.singletonList(
                new Product()
                        .setName("Category 001")
                        .setDescription("Category 001 | Description"));

        List<ProductDTO> productDTOS = this.productMapper.toPageDTO(products);
        assertThat(productDTOS.size()).isGreaterThanOrEqualTo(1);
    }
}
