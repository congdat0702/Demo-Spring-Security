package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.web.authentication.MyUserDetailsService;


@Configuration
@EnableWebSecurity
@Transactional
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 
   @Autowired
   private MyUserDetailsService myUserDetailsService;

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(myUserDetailsService);
   }
   



   @Override
   protected void configure(HttpSecurity http) throws Exception {

       http.csrf().disable();

 
       // Các trang không yêu cầu login
       http.authorizeRequests().antMatchers("/", "/home", "/logout").permitAll();
 
       // Trang /userInfo yêu cầu phải login với vai trò USER hoặc ADMIN.
       // Nếu chưa login, nó sẽ đưa tới trang /login.
       http.authorizeRequests().antMatchers("/userInfo/*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
       // Trang chỉ dành cho ADMIN
       http.authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')");
 
       // Khi người dùng đã login, nhưng sai trang
       // Ngoại lệ AccessDeniedException sẽ ném ra lỗi.
       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
       // Cấu hình cho Login Form.
       http.authorizeRequests().and().formLogin()//
    
               // Submit URL của trang login
               .loginProcessingUrl("/j_spring_security_check") // Submit URL
               .loginPage("/login")
               .defaultSuccessUrl("/home")
               .failureUrl("/login?error=true")
               .usernameParameter("username")
               .passwordParameter("password")
               
               // Cấu hình cho Logout Page.
               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

   }
}
