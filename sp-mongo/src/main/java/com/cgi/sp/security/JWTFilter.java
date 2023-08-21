package com.cgi.sp.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.StringUtils;

public class JWTFilter  extends BasicAuthenticationFilter {


    public JWTFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException,
        ServletException {

        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String jwt = this.resolveToken(httpServletRequest);
            
            System.out.println("Inside JWT Filter checking for "+ jwt);
            if (StringUtils.hasText(jwt)) {
               
                    Authentication authentication = getAuthentication(httpServletRequest);;
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                
            }
            filterChain.doFilter(servletRequest, servletResponse);

            this.resetAuthenticationAfterRequest();
        } catch (ExpiredJwtException eje) {
         
            ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          
        }
    }

    private void resetAuthenticationAfterRequest() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    private String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String jwt = bearerToken.substring(7, bearerToken.length());
            return jwt;
        }
        return null;
    }
    
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if (token != null) {
        // parse the token. 
			Jws<Claims> jws;
			try {
				jws = Jwts.parser().setSigningKey("QUJDMTIz").parseClaimsJws(token.replace("Bearer ", ""));
				String user = jws.getBody().getSubject();
				ArrayList<String> arrStr = jws.getBody().get("Roles", ArrayList.class);
				
				ArrayList<SimpleGrantedAuthority> arr = new ArrayList<SimpleGrantedAuthority>();
				
				for(String role:arrStr) {
				SimpleGrantedAuthority sr1 = new SimpleGrantedAuthority(role);
				arr.add(sr1);
				}
				
				
				//arr.add(new SimpleGrantedAuthority("ROLE_USER"));
				if (user != null) {
					return new UsernamePasswordAuthenticationToken(user, null,arr );
				}
			} catch (JwtException ex) {
				ex.printStackTrace();
				return null;
			}
			return null;
		}
		return null;
		// return new UsernamePasswordAuthenticationToken("user", null,new ArrayList<>() );
	}

	

}