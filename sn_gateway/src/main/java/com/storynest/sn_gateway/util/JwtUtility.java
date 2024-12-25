package com.storynest.sn_gateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtility {

    private static final String secretKey = "35e7160caff16826de0c4eccdc769b9a552d7be268638d0a9ddf549e0ea8d17527042813ae1a9509c1654b24cf8fbcba1ee37034bcd3d2dd8376c87d7ae302c0e091298e766fd82523efd929fa1d1462648800f6238a074d06fac655de0e63ad6037dc712ec02c970220dd34de1c6a9face35f69aee70c4ac1de86fbf42a610d2f92ff824153a2c3241563e7388c3eedbcdb3f60cca5d4016464785eaadc378e2ea7c23afe3277fbec3f28320f858c63285b252dbb54b83ae0921e9334e0ab2cad5e79fd8eab827faf2cc550cd77887bca3153e4f8c52475df225670447417df906b4fecdded1b8bf31f11fd75502f0f3ba92dc7ebbabc6713fe5d56d9187ceb";


    public void ValidateToken(String token) {
        Jwts.parser().verifyWith(getSigningKey()).build().parse(token);
    }

    private SecretKey getSigningKey(){
        byte[] bytes = Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(bytes);
    }

    private String getSecretKey() {
        return secretKey;
    }
}
