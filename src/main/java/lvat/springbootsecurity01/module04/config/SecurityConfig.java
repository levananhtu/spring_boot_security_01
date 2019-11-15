package lvat.springbootsecurity01.module04.config;

import lvat.springbootsecurity01.module04.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final GrantedAuthority USER_AUTHORITY = new SimpleGrantedAuthority("ROLE_USER");
    private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");

    @Autowired
    @Qualifier("myUserDetailService")
    private MyUserDetailService myUserDetailService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.myUserDetailService).passwordEncoder(passwordEncoder());
//        super.configure(auth);
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority(ADMIN_AUTHORITY.getAuthority());
        http.authorizeRequests().antMatchers("/user/**").hasAnyAuthority(USER_AUTHORITY.getAuthority(), ADMIN_AUTHORITY.getAuthority());
//        http.authorizeRequests().antMatchers("/admin/**").hasAuthority(ADMIN_AUTHORITY.getAuthority());
        http.authorizeRequests().antMatchers("/login").not().hasAnyAuthority(ADMIN_AUTHORITY.getAuthority(), USER_AUTHORITY.getAuthority());
//        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

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
//        super.configure(http);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
