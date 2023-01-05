package com.sparc.lams_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sparc.lams_service.util.CorsFilter;
import com.sparc.lams_service.util.SecurityFilter;
@CrossOrigin(origins = "*",maxAge =3600 )

@SuppressWarnings("rawtypes")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService service;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	 @Bean
	    CorsFilter corsFilter() {
	        CorsFilter filter = new CorsFilter();
	        return filter;
	    }

	 
	 
	 
	@Bean
	public SecurityFilter authenticationJwtTokenFilter() {
		return new SecurityFilter();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/api/auth/login","/api/auth/registerUser","/api/v1/dashboardpiechart",
						"/api/v1/dashboardvillageabstract","/api/v1/dashboardlandprogress","/api/v1/landclass","/api/v1/landclass/{owner}",
						"/api/v1/department","/api/v1/department/{id}","/uploadFile","/downloadFile/{fileName:.+}","/api/v1/landclass/{id}",
						"/api/v1/leasecasehistory","/api/v1/leasecasehistory/{village}/{landclass}/{leasecase}",
						"/api/v1/lcvillage","/api/v1/lcvillage/{id}","/api/v1/getleasecase/{village}/{landclass}","/api/v1/lclist/{village}/{landclass}/{leasecase}",
						"/api/v1/lcdocmap/{village}/{landclass}/{leasecase}","/api/v1/lcupdate/{village}/{landclass}/{leasecase}",
						"/api/v1/lcvillage/{id}","/api/v1/phase1allplots","/api/v1/phase1plotsbyvillage/{village}",
						"/api/v1/phase1plotsbyvillagelandclasslease/{phase}/{village}/{landclass}/{leasecase}",
						"/api/v1/updateplotleasecase/{phase}/{id}","/api/v1/updateplotwisestage/{phase}/{id}",
						"/api/v1/plotbyid/{id}","/api/v1/phase1plotsbyownership/{ownersip}","/api/v1/phase1plotsbylandclass/{landclass}",
						"/api/v1/phase1plotsbyvillage/{village}/{ownership}","/api/v1/phase1plotsbyvillage/{village}/{ownership}/{landclass}",
						"/api/v1/phase1plotsbykissam/{kissam}","/api/v1/phase1plotsbydlc/{dlc}","/api/v1/phase1plotsbyvillageanddlc/{village}/{dlc}",
						"/api/v1/phase1plotsbyvillageandkissam/{village}/{kissam}","/api/v1/phase1plotsbyvillagelandclass/{phase}/{village}/{landclass}","/api/v1/phase1plotsbyownershiplandclass/{ownership}/{landclass}",
						"/api/v1/getkhatanos","/api/v1/landdetails","/api/v1/role","/api/v1/primarylink","/api/v1/permission","/api/v1/permissionbyroleid",
						"/api/v1/deleterole","/api/v1/updaterole","/api/v1/removepermission","/api/v1/stage","/api/v1/stage/{landclass}","/api/v1/findstage/{stagecode}",
						"/api/auth/user","/api/v1/village","/api/v1/phasewisevillage/{phase}","/api/v1/village/{id}","/api/v1/getvillagename","/api/auth/user/{id}","/api/auth/getuser")
				.permitAll().anyRequest().authenticated()
				.and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}

}
