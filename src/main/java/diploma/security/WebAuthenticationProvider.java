package diploma.security;

import diploma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


@Component
public class WebAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailService;

    @Autowired
    public void setUserDetailService(@Qualifier("userServiceImpl") UserDetailsService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String ip = (String) authentication.getPrincipal();
        UserDetails userDetails = userDetailService.loadUserByUsername(ip);

        if(!((User)userDetails).isBanned()){
                                return new WebAuthenticationToken(userDetails);
        }

        return null;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(TinkerWebAuthenticationFilter.class);

    }
}
