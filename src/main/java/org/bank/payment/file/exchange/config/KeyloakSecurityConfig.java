package org.bank.payment.file.exchange.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMethodSecurity
@AllArgsConstructor
@Slf4j
public class KeyloakSecurityConfig {

    public static final String ADMiN = "admin";

    public static final String USER = "user";

    private final JwtAuthConverter jwtAuthConverter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(auth ->
                {
                    auth.requestMatchers(HttpMethod.GET, "/test/hello-1").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/test/test-error").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/actuator/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll(); // pour autoriser les docs Swagger
//                        auth.requestMatchers(HttpMethod.GET,"/test/hello-2").hasRole(ADMiN);
//                        auth.requestMatchers(HttpMethod.GET,"/test/hello-3").hasRole(USER);
//                        auth.requestMatchers(HttpMethod.GET,"/test/hello-4").hasAnyRole(USER,ADMiN);
                    auth.anyRequest().authenticated();
                }

        );

        httpSecurity.
                oauth2ResourceServer(oauth2 -> oauth2.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)
                ));

        httpSecurity.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return httpSecurity.build();
    }


}
