package br.pegz.tvp.security.jwt.util;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

@Service
public class RSACacheKeyService implements KeyService {

    private final Map<String, KeyPair> keypairMap;
    private final KeyPairGenerator keyPairGenerator;

    public RSACacheKeyService() throws InstantiationException {
        try {
            this.keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(4096);
            keypairMap = new HashMap<>();
        } catch (NoSuchAlgorithmException e) {
            throw new InstantiationException("Incorrect algorithm exception");
        }
    }

    @CachePut({"privateKey","publicKey"})
    public RSAPublicKey addKey(String tenant) {
        keypairMap.put(tenant, this.keyPairGenerator.generateKeyPair());
        return getPublic(tenant);
    }

    @Cacheable("publicKey")
    public RSAPublicKey getPublic(String tenant) {
        if(keypairMap.get(tenant) == null) {
            addKey(tenant);
        }
        return (RSAPublicKey) keypairMap.get(tenant).getPublic();
    }

    @Cacheable("privateKey")
    public RSAPrivateKey getPrivate(String tenant) {
        return (RSAPrivateKey) keypairMap.get(tenant).getPrivate();
    }

}
