package diploma.service.impl;

import diploma.model.Answer;
import diploma.repository.AnswerRepository;
import diploma.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class AnswerServiceImpl implements AnswerService {

    AnswerRepository answerRepository;

    @Autowired
    AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;


    }


    @Override
    public Answer create(Answer answer) {
        try {

            return answerRepository.save(answer);

        } catch (IllegalArgumentException e) {


            throw new NullPointerException("exception while  creating method");

        }

    }

    @Override
    public Answer readById(long id) {
        try{
          Optional<Answer> optional= answerRepository.findById(id);

          return optional.get();

        }catch(NoSuchElementException e ){

            throw new EntityNotFoundException("no such element");

        }


    }

    @Override
    public Answer update(Answer answer) {
        Answer answer1=readById(answer.getId());
        try{
            return answerRepository.save(answer);

        }catch(IllegalArgumentException e ){
            throw new NullPointerException("nothig to update");
        }


    }

    @Override
    public void delete(long id) {
        try{
           Answer answer = readById(id);

           answerRepository.delete(answer);

        }catch(NoSuchElementException e ){

            throw new EntityNotFoundException("Nothing to delete ");
        }


    }

    @Override
    public List<Answer> getAll() {
        try{
           return  answerRepository.getAll();

        }catch (NoSuchElementException e ){

        throw new EntityNotFoundException("no answers in DB") ;

        }


    }

    @Override
    public List<Answer> getAllByPostId(long id) {

        try{
        return    answerRepository.getAllByPostId(id);

        }catch(NoSuchElementException e ){

            throw new EntityNotFoundException("no posts founded");
        }


    }

    @Override
    public List<Answer> getALlByReplierId(long id) {

          return getAllByPostId(id);

    }

    @Override
    public boolean replyToPost(long answer_id, long answer_to) {
        try {
       return     answerRepository.replyToPost(answer_id, answer_to);
        }catch(Exception e ){

            throw  new IllegalArgumentException("values can not be inserted");
        }

    }
}
