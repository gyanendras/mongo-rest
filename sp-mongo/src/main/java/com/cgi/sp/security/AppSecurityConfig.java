package com.cgi.sp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig  {
	@Value("${pvtkey}")
	public  String privatkey;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.
       authorizeHttpRequests((authz) -> authz
               .anyRequest().authenticated()
    		   ) // some urls can be exempted
       
        .apply(MyCustomDsl.customDsl(privatkey))
        ;
        
        
       http.csrf((csrf) -> csrf
               .ignoringRequestMatchers("/**")
           );

            
            
           
            
        return http.build();
    }

}
