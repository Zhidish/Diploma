package diploma.service;

import diploma.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User create(User user);
    User readById(long id );
    User update(User user);
    void delete(long id );
    User findByIp(String ip);

}
