package com.Bookstore.Utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	
	public static final String SALT = "salt";
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPasswordGenerator() {
		String total = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder strBuild = new StringBuilder();
		Random rnd = new Random();
		while(strBuild.length()<18) {
			int index = (int) rnd.nextFloat()*total.length();
			strBuild.append(total.charAt(index));
		}
		String password = strBuild.toString();
		return password;
		
	}
		
	

}
