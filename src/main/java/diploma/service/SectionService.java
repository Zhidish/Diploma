package diploma.service;

import diploma.model.Section;

public interface SectionService {
    Section create(Section section);
    Section readById(long id );
    Section update(Section section);
    void delete(long id );


}
