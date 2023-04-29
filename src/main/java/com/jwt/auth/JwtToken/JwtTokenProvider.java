package com.jwt.auth.JwtToken;


import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.jwt.auth.Exception.UserNameException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
				public String generateToken(Authentication authentication) {
					String name=authentication.getName();
					
					Date currentDate=new Date();
					Date expireDate=new Date(currentDate.getTime()+1000*60*60*24);//24hrs
					
					String token=Jwts.builder()
							.setSubject(name)
							.setIssuedAt(currentDate)
							.setExpiration(expireDate)
							.signWith(SignatureAlgorithm.HS512, "vamsireddy")
							.compact();
							
					return token;
				}
				
				
				
				
		public String tokenToName(String token) {
			
			Claims claims=Jwts.parser()
					.setSigningKey("vamsireddy")
					.parseClaimsJws(token).getBody();
			return claims.getSubject();
		}
		
		
		public boolean validateToken(String token) {
			try {
				Jwts.parser()
				.setSigningKey("vamsireddy")
				.parseClaimsJws(token);
				return true;
			}
			catch(Exception e) {
				throw new UserNameException("error with api"+e.getMessage());
			}
			
			
		}
		
		
		
}
