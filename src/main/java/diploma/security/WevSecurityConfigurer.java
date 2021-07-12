package diploma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
@ComponentScan("diploma.websocket")
public class WevSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/app/hello").authenticated()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable();

        httpSecurity.addFilterAfter(tinkerWebAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.exceptionHandling().accessDeniedHandler(
                (request, response, accessDeniedException) -> response.sendRedirect("/forbidden")
        );


    }

    @Bean(name="specialTinkerBean")
    public TinkerWebAuthenticationFilter tinkerWebAuthenticationFilter() {
        return new TinkerWebAuthenticationFilter(authenticationManager);
    }


}
