// package velocityventures.mobili.config;
// import java.nio.charset.StandardCharsets;
// import java.util.Date;

// import javax.crypto.SecretKey;

// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtUtil {
//     private static final String SECRET_KEY = "ThisIsMyVerySecretKeyForJWTAuthenticationInMobiliProject2026";
//     private static final long EXPIRATION_TIME= 100*60*60;
//      private final SecretKey key =
//             Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

//     // Generate JWT Token
//     public String generateToken(String email) {

//         return Jwts.builder()
//                 .subject(email)
//                 .issuedAt(new Date())
//                 .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(key)
//                 .compact();
//     }
// }
