package com.example.ontap.utill;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;

//@Component
public class JwtUtil {

//        private final String secret = "mySecretKey"; // Khóa bí mật
//
//        // Tạo token từ tên tài khoản (username)
//        public String generateToken(String username) {
//            return Jwts.builder()
//                    .setSubject(username)
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 giờ
//                    .signWith(SignatureAlgorithm.HS512, secret)
//                    .compact();
//        }
//
//        // Giải mã token, lấy thông tin người dùng
//        public String extractUsername(String token) {
//            return getClaims(token).getSubject();
//        }
//
//        // Kiểm tra token có hợp lệ không
//        public boolean validateToken(String token) {
//            try {
//                return !getClaims(token).getExpiration().before(new Date());
//            } catch (Exception e) {
//                return false;
//            }
//        }
//
//        // Giải mã token
//        private Claims getClaims(String token) {
//            return Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody();
//        }
    }


