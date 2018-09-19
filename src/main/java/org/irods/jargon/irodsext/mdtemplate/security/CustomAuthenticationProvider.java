package org.irods.jargon.irodsext.mdtemplate.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static List<ApplicationUser> users = new ArrayList<ApplicationUser>();
	
	
	 public CustomAuthenticationProvider() {
	        users.add(new ApplicationUser("erin", "123", "ROLE_ADMIN"));
	        users.add(new ApplicationUser("mike", "234", "ROLE_ADMIN"));
	    }
	 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        Object credentials = authentication.getCredentials();
        System.out.println("credentials class: " + credentials.getClass());
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();
        
        System.out.println("CustomAuthenticationProvider - authenticate() - name :: " +name+ " , password :: " +password);

        Optional<ApplicationUser> userOptional = users.stream()
                                           .filter(u -> u.match(name, password))
                                           .findFirst();

        if (!userOptional.isPresent()) {
            throw new BadCredentialsException("Authentication failed for " + name);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().getRole()));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(name, password);
        return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
