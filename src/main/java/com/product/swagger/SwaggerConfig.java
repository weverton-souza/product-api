package com.product.swagger;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super();
    }
}
