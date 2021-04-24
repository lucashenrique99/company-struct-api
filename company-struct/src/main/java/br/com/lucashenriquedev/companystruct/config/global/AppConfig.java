package br.com.lucashenriquedev.companystruct.config.global;

import br.com.lucashenriquedev.companystruct.config.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        SecurityProperties.class
})
public class AppConfig {
}
