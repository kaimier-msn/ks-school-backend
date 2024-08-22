package com.ybvtc.userauthservice.sucurity;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationInMs;

    /**
     * 生成JWT令牌
     *
     * @param authentication 用户认证信息
     * @return 生成的JWT字符串
     */
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * 从JWT令牌中获取用户名
     *
     * @param token JWT令牌
     * @return 用户名
     */
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    /**
     * 验证JWT令牌是否有效
     *
     * @param authToken JWT令牌
     * @return 令牌是否有效
     */
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            // JWT签名错误
            System.out.println("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            // JWT格式错误
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            // JWT过期
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            // 不支持的JWT令牌
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            // JWT令牌为空或其他非法参数
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }

    /**
     * 从HTTP请求中获取JWT令牌
     *
     * @param request HTTP请求
     * @return JWT令牌字符串，如果不存在则返回null
     */
    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);  // 去掉 "Bearer " 前缀
        }
        return null;
    }
}