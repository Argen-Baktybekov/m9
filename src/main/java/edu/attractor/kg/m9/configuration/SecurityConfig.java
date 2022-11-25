package edu.attractor.kg.m9.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .defaultSuccessUrl("/",true)
                .failureUrl("/login.html?error=true")
                .and().logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email,password,enabled "
                        + "from customers "
                        + "where email = ?")
                .authoritiesByUsernameQuery("select username,authority "
                        + "from authorities "
                        + "where username = ?");
    }



//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
////        http.csrf()
////                .disable()
////                .authorizeRequests()
////                .antMatchers("/admin/**")
////                .hasRole("ADMIN")
////                .antMatchers("/anonymous*")
////                .anonymous()
////                .antMatchers("/login*")
////                .permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login.html")
////                .loginProcessingUrl("/perform_login")
////                .defaultSuccessUrl("/index.ftlh", true)
////                .failureUrl("/login.html?error=true")
////                .failureHandler(authenticationFailureHandler())
////                .and()
////                .logout()
////                .logoutUrl("/perform_logout")
////                .deleteCookies("JSESSIONID")
////                .logoutSuccessHandler(logoutSuccessHandler());
////        return http.build();
//
//        http.formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/index.ftlh",true)
//                .failureUrl("/login.html?error=true");
//        return http.build();
//    }
}
