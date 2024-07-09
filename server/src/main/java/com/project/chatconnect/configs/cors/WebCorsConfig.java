package com.project.chatconnect.configs.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Web cors config.
 *
 * @author Huy Dang
 */
@Configuration
public class WebCorsConfig {
    /**
     * Cors controller web mvc configure.
     *
     * @return the web mvc configure
     */
    @Bean
    public WebMvcConfigurer corsController() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080")
                        .allowedMethods("PUT", "DELETE", "GET", "POST");
            }
        };
    }
}
