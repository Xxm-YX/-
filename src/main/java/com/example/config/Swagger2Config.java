package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.OAS_30)        // 文档类型，不用理会，就是用SWAGGER_2
                .apiInfo(apiInfo()).select()                  // 接口文档信息设置，抽取到apiInfo()进行设置
//                .apis(RequestHandlerSelectors.any())    //这里的any代表所有的接口
//                .apis(RequestHandlerSelectors.withClassAnnotation())  //代表只有类上标注@Xxx注解的Controller才会生成文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation())  //只有方法上@Xxx注解的方法才会生成文档
                .apis(RequestHandlerSelectors.basePackage("com.example.web.controller"))
                .build() // Controller的扫描规则：对所有Controller生成接口文档
                .pathMapping("/") //统一为接口路径添加前缀，比如SpringCloud,有些网关配置了前缀但Swagger只读取了Controller
                .apiInfo(apiInfo());

    }

    /**
     * 接口文档信息设置
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("xx有限公司私密文档")
                .contact(new Contact("zyx",null,null))
                .description("测试swagger2文档")
                .version("1.0")
                .build();
    }
}
