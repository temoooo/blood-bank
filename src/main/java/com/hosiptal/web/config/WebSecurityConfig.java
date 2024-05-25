//package com.hosiptal.web.config;
//
//import com.hosiptal.web.service.CustomUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(
//                                "/supervisor/register",
//                                "/supervisor/register/",
//                                "/supervisor/login/",
//                                "/employee/login",
//                                "/employee/login/",
//                                "/css/login.css",
//                                "/css/supervisor.css",
//                                "/images/first-image.jpg",
//                                "/images/second-image.jpg"
//                        )
//                        .permitAll()
//                        .requestMatchers(HttpMethod.POST,"/supervisor/register/")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                )
//
//                .formLogin((form) -> form
//                        .loginPage("/supervisor/login")
//                        .usernameParameter("username")
//                        .defaultSuccessUrl("/supervisor/manage/")
//                        .loginProcessingUrl("/supervisor/login")
//                        .failureUrl("/supervisor/login?error=true")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//
//        return httpSecurity.build();
//    }
//
//    private CustomUserDetailsService customUserDetailsService;
//
//    public WebSecurityConfig(CustomUserDetailsService customUserDetailsService){
//        this.customUserDetailsService = customUserDetailsService;
//    }
//
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(customUserDetailsService);
//    }
//}
