package br.com.lucashenriquedev.companystruct.config.global;

import br.com.lucashenriquedev.companystruct.config.security.SecurityProperties;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        SecurityProperties.class,
        CloudinaryProperties.class
})
public class AppConfig {
}
