package diploma.repository;


import diploma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from client where ip=?1 ", nativeQuery = true)
    User findByIp(String ip);


}
