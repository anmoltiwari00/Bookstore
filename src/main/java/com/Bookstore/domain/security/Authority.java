package com.Bookstore.domain.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	
	private String authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
}
