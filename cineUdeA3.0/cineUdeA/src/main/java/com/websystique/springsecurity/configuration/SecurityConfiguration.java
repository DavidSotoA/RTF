package com.websystique.springsecurity.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /*
    @Autowired
    @Qualifier("userDetailsService")
        UserDetailsService userDetailsService;

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
*/
    @Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
                  
		.usersByUsernameQuery(
			"select cedula as username,contrasena as password, enabled from users where nombre=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	}	
        
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/confiteria").permitAll()
                .antMatchers("/estrenos").permitAll()
                .antMatchers("/cartelera").permitAll()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/redimir").access("hasRole('SOCIO') or hasRole('OPERARIO')")
                .antMatchers("/socio/**").access("hasRole('SOCIO')")
                .antMatchers("/funcionario/**").access("hasRole('FUNCIONARIO')")
                .antMatchers("/operario/**").access("hasRole('OPERARIO')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .httpBasic().and().formLogin()
                .and().csrf().disable().requiresChannel()
                .anyRequest().requiresSecure();
        http.portMapper().http(8080).mapsTo(8181);;
    }
    /*
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}*/
}