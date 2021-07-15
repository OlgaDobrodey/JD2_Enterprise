package by.it_academy.jd2.hw.example.airports.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService detailsService;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return detailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                httpBasic()
                .and().formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/admin/dashboard")
                .usernameParameter("login")
                .passwordParameter("password")
                .and().oauth2Login()
                .loginPage("/oauth_login").failureUrl("/oauth_login?error=true")
                .defaultSuccessUrl("/admin/dashboard")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout=true").and().exceptionHandling()
                .accessDeniedPage("/access_denied")
                .and().authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/oauth_login/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/airports").hasAuthority("ADMIN")
                .anyRequest().authenticated();
    }
}
