package com.stackroute.userservice.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import com.stackroute.userservice.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getUserId())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 30000 ))
				.signWith(SignatureAlgorithm.HS384, "secretkey").compact();
		Map<String, String> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("message", "User successfully logged in");
		return map;
	}
	


}
