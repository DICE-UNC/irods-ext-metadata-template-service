package org.irods.jargon.irodsext.mdtemplate.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static java.util.Collections.emptyList;

import java.io.UnsupportedEncodingException;

class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 864_000_000; // 10 days
	static final String SECRET = "ThisIsASuperSecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	static void addAuthentication(HttpServletResponse res, String username) throws UnsupportedEncodingException {
		System.out.println("6");
		System.out.println("Username :: " +username);
		String JWT = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS256, SECRET .getBytes("UTF-8"))
				.compact();
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		System.out.println("7");
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {	    	
			// parse the token.
			String user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();

			UserDetailsServiceImpl userDetailService = new UserDetailsServiceImpl();
			UserDetails userDetails = userDetailService.loadUserByUsername(user);
			System.out.println("TokenAuthenticationService - userDetails.getUsername() :: " +userDetails.getUsername());
			System.out.println("TokenAuthenticationService - userDetails.getPassword() :: " +userDetails.getPassword());

			return user != null ? new UsernamePasswordAuthenticationToken(user, userDetails, emptyList()) : null;
		}
		return null;
	}

	
}