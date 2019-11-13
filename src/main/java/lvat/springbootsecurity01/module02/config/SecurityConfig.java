package lvat.springbootsecurity01.module02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private GrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");
    private GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ADMIN");

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests().antMatchers("/user/**").hasAnyAuthority(userAuthority.getAuthority(), adminAuthority.getAuthority());
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority(adminAuthority.getAuthority());
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().antMatchers("/login").anonymous();
        http.authorizeRequests().antMatchers("/logout").not().anonymous();

        http.authorizeRequests().and().formLogin()
                .passwordParameter("password")
                .usernameParameter("username")
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_login")
                .defaultSuccessUrl("/user")
                .failureUrl("/login?message=error");
        http.logout()
                .logoutUrl("/j_spring_security_logout")
                .logoutSuccessUrl("/login?message=logout");
        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(30);
//        http.authorizeRequests().and().formLogin()
//                .passwordParameter("password")
//                .usernameParameter("username")
//                .loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_login")
//                .successForwardUrl("/user")
//                .failureForwardUrl("/login?message=error");
//        http.authorizeRequests().and().logout()
//                .logoutUrl("/j_spring_security_logout")
//                .logoutSuccessUrl("/login?message=logout");

//        http.authorizeRequests().and().formLogin()
//                .loginProcessingUrl("/j_spring_security_login")
//                .loginPage("/login")
//                .defaultSuccessUrl("/user")
//                .failureUrl("/login?message=error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        List<GrantedAuthority> userAuthorities = new LinkedList<>();
        userAuthorities.add(userAuthority);
        UserDetails userUser = new User("user", "123456", userAuthorities);
        builder.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(userUser);

        List<GrantedAuthority> adminAuthorities = new LinkedList<>();
        adminAuthorities.add(adminAuthority);
        adminAuthorities.add(userAuthority);
        UserDetails userAdmin = new User("admin", "123456", adminAuthorities);
        builder.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(userAdmin);
    }

}
