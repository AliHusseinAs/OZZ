package SODEFEND.SODEFEND.ConfigLayer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Spring'in bu sınıfı bir konfigürasyon olarak görmesi için
public class ConfigClass implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
        // Eğer “Authorization” başlığını özel olarak belirtmek istersen ekle:
        // .allowedHeaders("Authorization", "Content-Type", ...)
        ;
    }
}
