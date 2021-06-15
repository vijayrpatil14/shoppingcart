package com.atlavik.challenge.shoppingcart.configurations;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig
{

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(generateApiInfo())
           // .securityContexts(Arrays.asList(securityContext()))
           // .securitySchemes(Arrays.asList(apiKey()))
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build();
    }


//    private ApiKey apiKey()
//    {
//        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//    }
//
//
//    private SecurityContext securityContext()
//    {
//        return SecurityContext
//            .builder()
//            .securityReferences(defaultAuth())
//            .build();
//    }
//
//
//    List<SecurityReference> defaultAuth()
//    {
//        AuthorizationScope authorizationScope = new AuthorizationScope("swagger", "swagger");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }

    private ApiInfo generateApiInfo()
    {
        return new ApiInfo(
            "Atlavik - Senior Java Developer Challenge", "These APIs are for shopping cart", "Version 1.0 - mw",
            "urn:tos", "career@altavik.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    }

}