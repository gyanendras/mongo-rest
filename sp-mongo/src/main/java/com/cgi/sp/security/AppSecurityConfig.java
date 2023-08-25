package com.cgi.sp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
    		   ) // some urls can be exempted //signup, //registerme
       
        .apply(MyCustomDsl.customDsl(privatkey))
        ;
        
        
       http.csrf((csrf) -> csrf
               .ignoringRequestMatchers("/**")
           );

       http.httpBasic(Customizer.withDefaults())  ; 
            
           
            
        return http.build();
    }
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/signup", "/signin","/register");
    }

}
