package ma.bankconnect.config;

import ma.bankconnect.security.JWTAuthFilter;
import ma.bankconnect.security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ma.bankconnect.security.JWTAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JWTAuthenticationProvider jwtAuthenticationProvider;
    private final UserDetailService userDetailService;

    private final JWTAuthFilter jwtAuthFilter;

    @Autowired
    @Lazy
    public SecurityConfig(JWTAuthenticationProvider jwtAuthenticationProvider, UserDetailService userDetailService, JWTAuthFilter jwtAuthFilter) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.userDetailService = userDetailService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests().requestMatchers("/login/**", "/register", "/", "/verify")
                .permitAll()
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeHttpRequests()
                    .requestMatchers("/agent/**").hasAnyAuthority("AGENT")
                .and()
                    .authorizeHttpRequests()
                    .requestMatchers("/client/**").hasAnyAuthority("CLIENT")
                    .anyRequest()
                    .authenticated()
                .and()
                    .authenticationProvider(jwtAuthenticationProvider)
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .authenticationProvider(jwtAuthenticationProvider)
                .userDetailsService(userDetailService);
        return authenticationManagerBuilder.build();
    }

}
