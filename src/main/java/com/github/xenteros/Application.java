package com.github.xenteros;

import com.github.xenteros.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
public class Application implements CommandLineRunner{

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("currencyExchamge")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

    @Override
    public void run(String... args) throws Exception {

        currencyExchangeService.getExchangeRate("USD", "PLN", "0.5");
        currencyExchangeService.getExchangeRate("HUF","GBP", "0.75");
        currencyExchangeService.getExchangeRate("PLN","CNY", "0.33");
//        currencyExchangeService.getExchangeRate("HUF","JPN", "1.5");
//        currencyExchangeService.getExchangeRate("AUD","CNY", "0.75");
//        currencyExchangeService.getExchangeRate("HUF","GBP", "1");
//        currencyExchangeService.getExchangeRate("BTN","GBP", "0.75");
//        currencyExchangeService.getExchangeRate("HUF","ZWD", "0.75");
//        currencyExchangeService.getExchangeRate("HUF","ILS", "0.75");
//        currencyExchangeService.getExchangeRate("LYD","KES", "2");
//        currencyExchangeService.getExchangeRate("MYR","GBP", "0.75");

    }
}
