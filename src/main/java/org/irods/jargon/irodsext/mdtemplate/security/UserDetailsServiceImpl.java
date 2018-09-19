package org.irods.jargon.irodsext.mdtemplate.security;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetailsServiceImpl - loadUserByUsername()");
		ApplicationUser applicationUser = loadApplicationUserByUsername(username);
        
		if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
	}
	
	public ApplicationUser loadApplicationUserByUsername(String username) {
		return new ApplicationUser(username,"pass","");
	}

}
