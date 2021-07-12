package diploma.service;

import diploma.model.Tred;

import java.util.List;

public interface TredService {
    Tred create(Tred tred);
    Tred readById(long id );
    Tred update(Tred tred);
    void delete(long id);

     List<Tred> getTredBySection(String str);

}
