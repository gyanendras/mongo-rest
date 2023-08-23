package com.cgi.sp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


@Component
public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
	

	private static  String privatkey;
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        JWTFilter jwf = new JWTFilter(authenticationManager);
        jwf.setPvtKey(privatkey);
        http.addFilterBefore(jwf,UsernamePasswordAuthenticationFilter.class);
        
    }

    public static MyCustomDsl customDsl(String privatkey2) {
    	privatkey = privatkey2;
        return new MyCustomDsl();
    }
}