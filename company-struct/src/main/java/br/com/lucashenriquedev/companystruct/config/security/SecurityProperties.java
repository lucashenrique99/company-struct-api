package br.com.lucashenriquedev.companystruct.config.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("security")
public class SecurityProperties {

    private String appName = "Company Structure API";
    private Boolean isDev;
    private final TokenProperties tokenProperties = new TokenProperties();
    private final Credentials adminUi = new Credentials();
    private final SecurityUtils securityUtils = new SecurityUtils();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TokenProperties {

        private boolean enableHttps = false;

        private int cookieExpirationTime = 86400; // Default: one day
        private int tokenExpirationTime = 3600; // one hour

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Credentials {
        private String url = "*";
        private String CLIENT_ID = "@ngular";
        private String CLIENT_PASSWORD = "7EP!Aqo86U&+PuSg";
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SecurityUtils {

        private String signingKey = "nHNp7j4yHsbwTK5Dqsg2wJcnGEqpgJT8zwh9sqcXEZpv6UdTCygP7xqZqpzrQjL2sPJwTn4qZVt";

    }

}
