package br.pegz.tvp.security.jwt.util;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public interface KeyService {
    RSAPublicKey addKey(String tenant);
    RSAPublicKey getPublic(String tenant);
    RSAPrivateKey getPrivate(String tenant);
}
