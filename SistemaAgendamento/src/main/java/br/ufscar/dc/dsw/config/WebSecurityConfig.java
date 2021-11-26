package br.ufscar.dc.dsw.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;

import br.ufscar.dc.dsw.security.PessoaDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new PessoaDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()

		// Controladores REST
		.antMatchers("/clientes", "/profissionais", "/consultas").permitAll()
		.antMatchers("/clientes/{\\d+}", "/profissionais/{\\d+}").permitAll()
		.antMatchers("/consultas/{\\d+}").permitAll()
		.antMatchers("/profissionais/especialidades/{\\w+}").permitAll()
		.antMatchers("/consultas/clientes/{\\d+}").permitAll()
		.antMatchers("/consultas/profissionais/{\\d+}").permitAll()
				
		// Demais linhas
		.antMatchers("/error", "/login/**", "/js/**", "/homecontroller/**", "/home/**", "/", "/consultas/listar").permitAll()
        .antMatchers("/css/**", "/image/**", "/webjars/**").permitAll()
        //.antMatchers("/consultas/listar").hasRole(["PROFISSIONAL", "CLIENTE", "ADMIN"])
		.antMatchers("/consultas/**").hasRole("CLIENTE")
		.antMatchers("/profissionais/**", "/clientes/**").hasRole("ADMIN")
        .antMatchers("/admins/**").hasRole("ADMIN")
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll();
	}
}
