// com.game.config.SecurityConfig.java
package com.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 密码加密器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 安全过滤链配置
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 允许匿名访问的路径
                        .requestMatchers("/", "/game", "/game/**", "/gameSync", "/login").permitAll()
                        // 后台管理路径需要认证
                        .requestMatchers("/admin/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")  // 自定义登录页
                        .defaultSuccessUrl("/admin", true)  // 登录成功后跳转
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")  // 退出登录后跳转
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());  // 开发阶段关闭CSRF

        return http.build();
    }

    // 配置用户（admin/admin123）
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin123"))  // 密码加密存储
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}