package com.cgi.sp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig  {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.
       authorizeHttpRequests((authz) -> authz
               .anyRequest().authenticated()
    		   )
       
        .apply(MyCustomDsl.customDsl())
        ;
        
        
        

            
            
           
            
        return http.build();
    }

}
