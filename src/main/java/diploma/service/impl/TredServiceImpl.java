package diploma.service.impl;

import diploma.model.Tred;
import diploma.repository.TredRepository;
import diploma.service.TredService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class TredServiceImpl  implements TredService {

     private TredRepository tredRepository;


     TredServiceImpl(TredRepository tredRepository){
         this.tredRepository=tredRepository;

     }


    @Override
    public Tred create(Tred tred) {
        try{
             return tredRepository.save(tred);

        }catch(IllegalArgumentException e){
            throw new NullPointerException("no tred passed");
        }



    }

    @Override
    public Tred readById(long id) {
         try {
             Optional<Tred> optional = tredRepository.findById(id);
             return optional.get();
         }catch(NoSuchElementException e){
             throw  new EntityNotFoundException("Entity not foudn ");

         }

    }

    @Override
    public Tred update(Tred tred) {
             Tred oldTred = readById(tred.getTred_id());
         try{
            return tredRepository.save(tred);
         }catch(IllegalArgumentException e ){
             throw new NullPointerException("");
         }


    }

    @Override
    public void delete(long id) {
        try{
            Tred tred = readById(id);
            tredRepository.delete(tred);

        }catch(NoSuchElementException e){
            throw new EntityNotFoundException("No tred found in DB");

        }


    }

    @Override
    public List<Tred> getTredBySection(String str) {

         try {
             return tredRepository.getTredBySection(str);
         }catch(NoSuchElementException e  ){

              throw new EntityNotFoundException("no such elemnt");


         }

    }
}
