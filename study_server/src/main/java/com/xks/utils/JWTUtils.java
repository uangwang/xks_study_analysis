package com.xks.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    // 过期时间的最小单位
    private static long EXPIRATION_TIME_UNIT = 60 * 60 * 1000L;
    // 签名需要的盐
    private static String SIGNATURE_SALT = "xiaokeshui";

    //创建token
    public static String createToken(String id, Map<String, String> map, int time){
        Date currentDate = new Date();
        Date expirationDate = new Date(System.currentTimeMillis() + time * EXPIRATION_TIME_UNIT);
        JWTCreator.Builder builder = JWT.create();
        builder.withAudience(id);//令牌
        builder.withIssuedAt(currentDate);
        builder.withExpiresAt(expirationDate);
        if (map != null){
            map.forEach((k,v)->{
                builder.withClaim(k,v);
            });
        }
        //加密签名
        return builder.sign(Algorithm.HMAC256(SIGNATURE_SALT+id));
    }

    // 获取身份
    public static String getAudienceByToken(String token){
        return JWT.decode(token).getAudience().get(0);
    }


    // 解析token
     /*
      infoCode:
              1：解析成功
              2：签名异常
              3：Token过期
              4：签名算法不一致
     */
    public static Map<String, Object> variefToken(String token, String audience){
        Map<String, Object> map = new HashMap<>();
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SIGNATURE_SALT + audience)).build();
            decodedJWT = verifier.verify(token);
            map.put("infoCode",1);
            map.put("decodedJWT",decodedJWT);
        }catch (SignatureVerificationException e){
            map.put("infoCode",2);
            map.put("decodedJWT",decodedJWT);
        }catch (TokenExpiredException e){
            map.put("infoCode",3);
            map.put("decodedJWT",decodedJWT);
        }catch (AlgorithmMismatchException e){
            map.put("infoCode",4);
            map.put("decodedJWT",decodedJWT);
        }catch (Exception e){
            map.put("infoCode",5);
            map.put("decodedJWT",decodedJWT);
        }
        return map;
    }


    // 获取token中自定义的所有数据
    public static Map<String, String> getTokenInfo(String token){
        Map<String, String> map = new HashMap<>();
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        claims.forEach((k,v)->{
            map.put(k,v.asString());
        });
        return map;
    }


    // 根据key获取token中自定义的数据
    public static String getInfoByTokenAndName(String token, String name){
        Claim claim = JWT.decode(token).getClaim(name);
        return claim.asString();

    }


}
