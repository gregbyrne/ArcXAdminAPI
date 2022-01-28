package com.app.arcx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomControllerConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000",
                        "http://localhost:8080",
                        "https://arcx-development-admin-ui.devsecops-eval.epa.gov",
                        "http://arcx-development-admin-ui.devsecops-eval.epa.gov",
                        "https://arcx-admin-ui-stg.devsecops-eval.epa.gov",
                        "http://arcx-admin-ui.devsecops-dev.aws.epa.gov",
                        "https://arcx-admin-ui.devsecops-dev.aws.epa.gov",
                        "http://climateadaptationadminstg.epa.gov",
                        "https://climateadaptationadminstg.epa.gov",
                        "*")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }
}
