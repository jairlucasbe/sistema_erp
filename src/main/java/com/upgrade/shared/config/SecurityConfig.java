package com.upgrade.shared.config;
// package com.upgrade.erp.modules.auth.config.security;

// import com.upgrade.erp.modules.auth.config.security.filter.JwtTokenValidator;
// import com.upgrade.erp.modules.auth.config.security.utils.jwt.JwtUtils;
// import com.upgrade.erp.modules.auth.services.UserDetailServiceImpl;
// import com.upgrade.erp.modules.auth.views.LoginView;
// import com.vaadin.flow.spring.security.VaadinWebSecurity;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig{
    
//     @Autowired
//     private JwtUtils jwtUtils;

//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationProvider authenticationProvider) throws Exception {
//         return httpSecurity
//                 .csrf(csrf -> csrf.disable())
//                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .authorizeHttpRequests(http -> {
//                     // EndPoints publicos
//                     http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();
//                     http.requestMatchers(HttpMethod.GET, "/auth").permitAll();
//                     http.requestMatchers(HttpMethod.GET, "/authentication").permitAll();

//                     // EndPoints Privados
//                     http.requestMatchers(HttpMethod.GET, "/method/get").hasAuthority("READ");
//                     http.requestMatchers(HttpMethod.POST, "/method/post").hasAuthority("CREATE");
//                     http.requestMatchers(HttpMethod.DELETE, "/method/delete").hasAuthority("DELETE");
//                     http.requestMatchers(HttpMethod.PUT, "/method/put").hasAuthority("UPDATE");

//                     http.anyRequest().denyAll();
//                 })
//                 .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
//                 .build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     @Bean
//     public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
//         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//         provider.setPasswordEncoder(passwordEncoder());
//         provider.setUserDetailsService(userDetailService);
//         return provider;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
