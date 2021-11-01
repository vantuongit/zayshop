package edu.vinaenter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource).passwordEncoder(passwordEncoder())/* .rolePrefix("ROLE_") */
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery(
						"select username, name from users u inner join role r on u.role_id = r.id where username= ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/cat/edit/**").access("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
				.antMatchers("/admin/cat/add/**").access("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
				.antMatchers("/admin/cat/delete/**").access("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
				.antMatchers("/admin/news/edit/**").access("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
				.antMatchers("/admin/news/add/**").access("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
				.antMatchers("/admin/news/delete/**").access("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
				.antMatchers("/admin/contact/delete/**").access("hasAnyRole('ROLE_ADMIN')")
				.antMatchers("/admin/user/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_EDITOR')")
				.antMatchers("/").permitAll()
				.and()
				.formLogin()
				.usernameParameter("username")
				.passwordParameter("password")
				.loginPage("/auth/login")
				.loginProcessingUrl("/auth/login")
				.failureUrl("/auth/login?msg=Error")
				.defaultSuccessUrl("/admin/index", false)//true vao trang trc do false mac dinh vao admin/index
				.and()
				.logout()
				.logoutUrl("/auth/logout")
				.logoutSuccessUrl("/auth/login")
				.and()
				.exceptionHandling()
				.accessDeniedPage("/error/403")
				.and()
				.csrf().disable(); 
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
