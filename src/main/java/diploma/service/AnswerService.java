package diploma.service;

import diploma.model.Answer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerService {

    Answer create(Answer answer);

    Answer readById(long id );

    Answer  update(Answer answer);

     void delete(long id );



    List<Answer> getAll();

    List<Answer>getAllByPostId(long id );

    List<Answer> getALlByReplierId(long id );

    boolean replyToPost(long answer_id,long answer_to);


}
