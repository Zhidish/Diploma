package diploma.service.impl;

import diploma.model.User;
import diploma.repository.UserRepository;
import diploma.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service("userServiceImpl")
public class UserServiceImpl  implements UserService {

   private UserRepository userRepository;



    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;

    }
    @Override
    public User create(User user) {
            try{
             return   userRepository.save(user);

            }catch(IllegalArgumentException e ){
                throw new NullPointerException("Empty elemnt passed");


            }

    }

    @Override
    public User readById(long id) {

        try{
            Optional<User> optional = userRepository.findById(id);
          return  optional.get();


        }catch(NoSuchElementException e ){
            throw new EntityNotFoundException("No user found");
        }



    }

    @Override
    public User update(User user) {
        User oldUser =  readById(user.getIdOwner());


        try{
         return   userRepository.save(user);


        }catch(IllegalArgumentException e ){
            throw new NullPointerException("epty user passed");


        }


    }

    @Override
    public void delete(long id) {


        try{
            User user = readById(id);
            userRepository.delete(user);


        }catch (NoSuchElementException e ){
            throw new EntityNotFoundException("no user found");

        }



    }

    @Override
    public User findByIp(String ip) {
        try{
            return userRepository.findByIp(ip);

        }catch(NullPointerException e ){

            throw new EntityNotFoundException("No Ip exists");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails;
        try {

            if(! ((userDetails = findByIp(username)) == null))
                return userDetails;
            }catch(NullPointerException e ){




        }

        User user = new User();
        user.setIp(username);

        return create(user);

    }
}
