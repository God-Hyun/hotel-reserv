package com.example.hotelReserv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll() //로그인하지 않아도 모든 페이지 접근 가능
                                .requestMatchers("/register", "/login").permitAll()
                                .anyRequest().authenticated()  // 나머지 요청은 인증된 사용자만 접근 가능 게시판 글쓰기나 수정 ? 등등 댓글 포함
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // 커스텀 로그인 페이지
                                .defaultSuccessUrl("/bookings/main", true)  // 로그인 성공 후 이동할 URL
                                .failureUrl("/login?error=true") // 로그인 실패 시 리다이렉트
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/main")
                                .invalidateHttpSession(true)
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
