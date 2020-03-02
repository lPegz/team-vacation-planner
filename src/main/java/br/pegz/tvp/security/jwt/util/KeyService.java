package br.pegz.tvp.security.jwt.util;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface KeyService {
    PublicKey addKey(String tenant);
    PublicKey getPublic(String tenant);
    PrivateKey getPrivate(String tenant);
}
