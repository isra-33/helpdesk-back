package com.example.helpdeskback.config;

import java.security.Key;
import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64.Decoder;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY="8a217401ae4be9d4d2a7e9e2e9398a7a82aeb75f7f9419110e5f81ca46665f2a";

    public String extractUserEmail(String token) {
        
        return extractClaim(token, Claims::getSubject);
    }

    //this method is to extract any claim from my token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //generate a token without extraction
    public String generateToken(UserDetails userDetails ){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
        Map<String, Object> extratClaims,
        UserDetails userdDetails
    ){
        return Jwts.builder()
        .setClaims(extratClaims)
        .setSubject(userdDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000*60 *24))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
    }
    // method to validate if the token belongs to the userdetails
    public boolean validateToken(String token, UserDetails userDetails){
        //ps : the username is the userEmail but the SB JWT applies username in general
        final String username= extractUserEmail(token);
        return(username.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
       return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
        .parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();  
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
