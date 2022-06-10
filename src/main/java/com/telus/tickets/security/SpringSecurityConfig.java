package com.telus.tickets.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Aqui van todas las rutas de accesso public
		http.authorizeRequests().antMatchers("/css/**", "/createUser","/images/**","/js/**").permitAll()
		.antMatchers("/").hasAnyAuthority("admin","seller","user")
		//.antMatchers("/index").hasAuthority("ADMIN")
		.antMatchers("/politicas/","/manuales/","/instructivos/","/solicitudes/").hasAnyAuthority("ADMIN","Jefaturas","Negocios","Administrativos","Cajas")
		.antMatchers("/politicas/gerencia/**","/manuales/gerencia/**","/instructivos/gerencia/**","/solicitudes/**").hasAnyAuthority("ADMIN","Jefaturas")
		.antMatchers("/usuarios/**","/documentos/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
	
		PasswordEncoder encoder= this.passwordEncoder;
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder)
		.usersByUsernameQuery("select user_name, password, active from user where user_name=?")
		.authoritiesByUsernameQuery("SELECT u.user_name, r.name_rol FROM rol as r inner join user as u on (r.id_rol=u.id_role) where u.user_name=?");
		
	}
	
	
}
