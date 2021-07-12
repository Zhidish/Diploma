package diploma.repository;


import diploma.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "select * from post where id_owner=?1 ",nativeQuery=true)
    List<Post> getAllByOwnerId(long id);

    @Query(value="SELECT * FROM post where tred_id=?1",nativeQuery = true)
    List<Post> getAllByTredId( long id);



}
