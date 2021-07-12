package diploma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class TinkerWebAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    public TinkerWebAuthenticationFilter(AuthenticationManager authenticationManager) {
        super("/home");
        setAuthenticationManager(authenticationManager);


       /* setAuthenticationSuccessHandler(((request, response, authentication) -> {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    request.getRequestDispatcher(request.getServletPath() + request.getPathInfo()).forward(request, response);
                }));
*/
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        response.sendRedirect("/fchan");
    }





    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String ip = "";
        ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null || "".equals(ip)) {
            ip = request.getRemoteAddr();
        }
        System.err.println(ip);
        Authentication authentication=  new UsernamePasswordAuthenticationToken(ip,null);
        return getAuthenticationManager().authenticate(authentication);

    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        SecurityContextHolder.clearContext();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.sendRedirect("/login-form?error");
    }

}
