package com.bruceking.main.loginPage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired(required = false)
    private CustomerService customerService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerService);
    }

//    @Autowired(required = false)
//    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    UsernamePasswordCode UsernamePasswordCode() throws Exception {
        UsernamePasswordCode filter = new UsernamePasswordCode();
        filter.setAuthenticationManager(authenticationManagerBean());
//        filter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        return filter;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/css/**","/fonts/**","/images/**","/js/**","/", "/assets/**","/getSessionID",
                    "/getUserInfo","/goodsIndex","/search/**","/auLogin","/setAuthCode","/login/**",
                    "/SignTransaction","insertTransaction").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin(form -> form
                    .loginPage("/login")
                    .permitAll()
//                    .successHandler(customAuthenticationSuccessHandler)
            ).httpBasic().and().logout().logoutSuccessUrl("/");
        http.addFilterAt(UsernamePasswordCode(), UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
    }

}
