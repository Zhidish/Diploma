package diploma.service.impl;

import diploma.model.Section;
import diploma.repository.SectionRepository;
import diploma.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class SectionServiceImpl implements SectionService {


    private SectionRepository sectionRepository;


    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section create(Section section) {
        try{
               return sectionRepository.save(section);

        }catch(IllegalArgumentException e ){
            throw new NullPointerException("Empty  section created");

        }



    }

    @Override
    public Section readById(long id) {
        try{
            Optional<Section> optional = sectionRepository.findById(id);
            return optional.get();
        }catch(NoSuchElementException e ){
            throw new EntityNotFoundException("No section found  in DB");
        }



    }

    @Override
    public Section update(Section section) {
        Section oldSection = readById(section.getId());
        try{
          return  sectionRepository.save(section);

        }catch (IllegalArgumentException e ){
            throw new NullPointerException("Empty section");
        }


    }

    @Override
    public void delete(long id) {
        try{
          Section section = readById(id);
          sectionRepository.delete(section);
        }catch (NoSuchElementException e ){
            throw new EntityNotFoundException("No section Found in DB");
        }

    }
}
