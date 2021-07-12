package diploma.repository;

import diploma.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {


    @Query(value="SELECT  * FROM answer",nativeQuery=true)
    List<Answer> getAll();


        // select all posts that have  replied to post which we select by id
    @Query(value="SELECT  id , answer_id, answer_to, message, tred_id FROM answer INNER JOIN post p on  p.post_id=answer.answer_id WHERE answer_to=?1",nativeQuery=true)
    List<Answer>getAllByPostId(long id );




    @Query(value="SELECT * FROM answer WHERE answer_to=?1", nativeQuery=true)
    List<Answer> getALlByReplierId(long id );



    @Query(value="INSERT INTO answer(answer_id,answer_to) VALUES(?1,?2)",nativeQuery = true)
    boolean replyToPost(long answer_id,long answer_to);


}
