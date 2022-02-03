package ua.cv.vacancy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @autor shd on 24.11.2021
 * @created 20.01.2022 - 17:53
 * @project vacancy
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/vacancy").permitAll()
                .antMatchers("/vacan").hasRole("ADMIN")
                .antMatchers("/vacan").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/vacancy/login").defaultSuccessUrl("/vacancy/vacan").permitAll()
                .and()
//                .logout().logoutUrl("/logout").permitAll();
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin").password("1").roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager();
    }

    protected PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }
}