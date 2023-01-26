package com.az.ejemplobddos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {

    @Autowired
    DataSource dataSource;

    @Bean
    public UserDetailsManager manejadorUsuarios(DataSource ds) {
        JdbcUserDetailsManager manejador = new JdbcUserDetailsManager(ds);
        manejador.setUsersByUsernameQuery("SELECT login,password,activo FROM usuarios WHERE login = ?");
        manejador.setAuthoritiesByUsernameQuery("SELECT login,rol FROM usuarios_roles WHERE login = ?");
        return manejador;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}
