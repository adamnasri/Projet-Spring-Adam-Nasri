package fr.cesi.ril17.spring.demo.SwaggerConfig;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    /*public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.cesi.ril17.srping.demo.controllers.api"))
                .paths(PathSelectors.any())
                .build();
    }*/
}
