package com.product.resource;

import com.product.abstracts.AbstractResource;
import com.product.dto.ProductDTO;
import com.product.service.ProductServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/products")
@Api(value = "Product", tags = "product")
public class ProductResourceImpl extends AbstractResource<ProductDTO, String> {
    @Autowired
    public ProductResourceImpl(final ProductServiceImpl service) {
        super(service);
    }
}
