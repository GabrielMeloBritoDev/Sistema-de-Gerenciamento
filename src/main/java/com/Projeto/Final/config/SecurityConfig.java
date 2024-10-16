package com.Projeto.Final.config;

import com.Projeto.Final.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Desabilita CSRF temporariamente para testes com Postman
                .authorizeRequests()
                .requestMatchers(HttpMethod.POST, "/clientes/cadastro").permitAll()  // Permite POST para cadastro de clientes
                .requestMatchers(HttpMethod.DELETE, "/clientes/**").permitAll()  // Permite DELETE para deletar clientes
                .requestMatchers(HttpMethod.POST, "/usuarios/cadastro").permitAll()  // Permite POST para cadastro de usuários
                .anyRequest().authenticated()  // Exige autenticação para todas as outras rotas
                .and()
                .formLogin().disable();  // Desabilita o formulário de login

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




