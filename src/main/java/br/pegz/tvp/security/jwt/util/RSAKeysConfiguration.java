package br.pegz.tvp.security.jwt.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.interfaces.RSAPublicKey;

@Configuration
public class RSAKeysConfiguration {



    @Bean
    public RSAPublicKey rsaPublicKey() {

        return null;
    }
}
