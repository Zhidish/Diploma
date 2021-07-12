package diploma.repository;

import diploma.model.Tred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TredRepository  extends JpaRepository<Tred, Long > {



    @Query(value =" SELECT * FROM tred inner join section s on s.id = tred.section_id where teg=?1",nativeQuery = true)
    List<Tred> getTredBySection(String str);



}
