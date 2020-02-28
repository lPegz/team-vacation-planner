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

    private final RSAPublicKey rsaPublicKey;

    private final RSAPrivateKey rsaPrivateKey;

    public String generateJwt(String teamname, String username) {
        Algorithm alg = Algorithm.RSA512(rsaPublicKey, rsaPrivateKey);
        return JWT.create()
                .withClaim("team", teamname)
                .withClaim("username", username)
                .withIssuer(teamname)
                .withSubject(username)
                .sign(alg);
    }
}
