//package com.example.logistics.utilities;
//
//import com.example.logistics.services.EmployeeDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    private EmployeeDetailsService employeeDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // Configure which endpoints need authentication, which do not
//        return http
//            //.userDetailsService(employeeDetailsService)
//            .authorizeHttpRequests(auth ->
//                auth
//                    .requestMatchers("/**", "/api/**", "/login/**", "/employees")
//                    .permitAll()// or .anonymous()
//                    .anyRequest()
//                    .authenticated())
//            .build();
//    }
//}