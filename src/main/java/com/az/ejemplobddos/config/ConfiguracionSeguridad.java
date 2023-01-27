package com.az.ejemplobddos.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity
public class ConfiguracionSeguridad {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfiguracionSeguridad.class);
    @Autowired
    DataSource dataSource;

    @Bean
    public UserDetailsManager manejadorUsuarios(DataSource ds) {
        LOGGER.debug("Bean UserDetailsManager");
        JdbcUserDetailsManager manejador = new JdbcUserDetailsManager(ds);
        manejador.setUsersByUsernameQuery("SELECT login,password,activo FROM usuarios WHERE login = ?");
        manejador.setAuthoritiesByUsernameQuery("SELECT login,rol FROM usuarios_roles WHERE login = ?");
        return manejador;
    }

    @Bean
    public AuthenticationManager manejadorAutenticacion(
            AuthenticationConfiguration config) throws Exception {
        LOGGER.debug("Bean AuthenticationManager {}", config.getAuthenticationManager().toString());
        return config.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        LOGGER.debug("Bean PasswordEncoder {}", encoder.getClass().getCanonicalName());
        return encoder;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
        httpSec.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/logout")
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(HttpServletResponse.SC_OK);
                });
        return httpSec.build();
    }
}
