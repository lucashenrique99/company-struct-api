package br.com.lucashenriquedev.companystruct.config.global;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfigurationProperties("cloudinary")
public class CloudinaryProperties {

    private String apiKey;
    private String apiSecret;
    private String cloudName;

}
