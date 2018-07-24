package org.irods.jargon.irodsext.mdtemplate.configuration;

import org.irods.jargon.irodsext.mdtemplate.service.IrodsSampleTemplateService;
import org.irods.jargon.irodsext.mdtemplate.service.IrodsSampleTemplateServiceImpl;
import org.irods.jargon.metadatatemplate.AbstractMetadataService;
import org.irodsext.mdtemplate.services.IrodsExtMetadataServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "org.irods.jargon.irodsext.mdtemplate.codegen.languages.SpringCodegen", date = "2018-07-05T20:33:48.236Z")

@Configuration
@ComponentScan({ "org.irodsext.mdtemplate", "org.irods.jargon.metadatatemplate" })
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("iRODS Metadata Templates")
            .description("iRODS Metadata Templates")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", "apiteam@swagger.io"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("org.irods.jargon.irodsext.mdtemplate.api"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }
    
    
    
    @Bean
    public IrodsSampleTemplateService irodsSampleTemplateService(){
    	return new IrodsSampleTemplateServiceImpl();
    }

    
    @Bean
    public AbstractMetadataService abstractMetadataService(){
    	return new IrodsExtMetadataServiceImpl();
    }
    
}
