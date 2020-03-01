package br.pegz.tvp.security.jwt.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

@Service
@EnableCaching
public class KeyService {

    private final Map<String, RSAPrivateKey> rsaPrivateKeyMap = new HashMap<>();
    private final Map<String, RSAPublicKey> rsaPublicKeyMap = new HashMap<>();

    public RSAPublicKey addKey(String tenant) {
        return null;
    }

    public RSAPublicKey getPublic(String tenant) {
        return null;
    }

    public RSAPrivateKey getPrivate(String name) {
        return null;
    }

}
