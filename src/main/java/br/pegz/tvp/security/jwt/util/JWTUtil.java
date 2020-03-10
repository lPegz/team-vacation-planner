package br.pegz.tvp.security.jwt.util;

import com.auth0.jwk.Jwk;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@RequiredArgsConstructor
public class JWTUtil {

    private final KeyService keyService;

    public String generateJwt(String teamname, String username) {
        RSAPublicKey rsaPublicKey = keyService.getPublic(teamname);
        RSAPrivateKey rsaPrivateKey = keyService.getPrivate(teamname);
        Algorithm alg = Algorithm.RSA512(rsaPublicKey, rsaPrivateKey);
        return JWT.create()
                .withClaim("team", teamname)
                .withClaim("username", username)
                .withIssuer(teamname)
                .withSubject(username)
                .sign(alg);
    }
}
