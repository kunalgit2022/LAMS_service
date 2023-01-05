package com.sparc.lams_service.util;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.Filter;

public class CorsFilter implements Filter{
	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException {

	    }
	 
	 @Bean
	 CorsConfigurationSource corsConfigurationSource() {
	 	CorsConfiguration configuration = new CorsConfiguration();
	 	configuration.setAllowedOrigins(Arrays.asList("*"));
	 	configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	 	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	 	source.registerCorsConfiguration("/**", configuration);
	 	return source;
	 }
	 
	 @Override
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        HttpServletRequest request= (HttpServletRequest) servletRequest;

	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
	        response.setHeader("Access-Control-Allow-Headers", "*");
	        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
//            response.setHeader("Access-Control-Allow-Credentials",true );
//            response.addIntHeader("Access-Control-Max-Age", 180);
	        filterChain.doFilter(servletRequest, servletResponse);
	    }

	    @Override
	    public void destroy() {

	    }
}
