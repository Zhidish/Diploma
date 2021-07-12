package diploma.security;

import diploma.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class WebAuthenticationToken implements Authentication
{

    private UserDetails userDetails;
    private boolean isAuthenticated;

  public  WebAuthenticationToken(UserDetails userDetails){
        this.userDetails=userDetails;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return userDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return ((User) userDetails).getIp(); }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            this.isAuthenticated=isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}