//package com.startsup.merchant.config;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT name, encrypted_pass, enabled FROM merchantdb.user where name=?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT name, role from merchantdb.user where name=?");
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.POST, "/api/v1/**").hasAuthority("admin")
//                        .requestMatchers(HttpMethod.PUT, "/api/v1/**").hasAuthority("admin")
//                        .requestMatchers(HttpMethod.DELETE, "/api/v1/**").hasAuthority("admin")
//                        .requestMatchers(HttpMethod.POST, "/api/v1/**").hasAuthority("manager")
//                        .requestMatchers(HttpMethod.PUT, "/api/v1/**").hasAuthority("manager")
//                        .requestMatchers(HttpMethod.GET, "/api/v1/**").authenticated()
//                        .requestMatchers(HttpMethod.GET, "/swagger-ui").anonymous()
//        );
//
//        httpSecurity.httpBasic(Customizer.withDefaults());
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        return httpSecurity.build();
//    }
//}
