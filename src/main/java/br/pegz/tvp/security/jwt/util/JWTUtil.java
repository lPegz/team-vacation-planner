package br.pegz.tvp.security.jwt.util;

import com.auth0.jwk.InvalidPublicKeyException;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;

@Component
@Value
public class JWTUtil {

    private final Jwk jwk;
    private final PublicKey rsaPub;
    private final PublicKey rsaPrivate;

    public JWTUtil() throws InvalidPublicKeyException {
        jwk = new Jwk("","","","", Collections.emptyList(),
                "", Collections.emptyList(), "", Collections.emptyMap());
        rsaPub = jwk.getPublicKey();
//        rsaPrivate = Private;
//        new JwkProviderBuilder().
    }

    public String generateJwt(String teamname, String username) {
        Algorithm alg = Algorithm.RSA512(rsaPub, rsaPrivate);
        return JWT.create()
                .withClaim("team", teamname)
                .withClaim("username", username)
                .withIssuer(teamname)
                .withSubject(username)
                .sign(alg);
    }
}
