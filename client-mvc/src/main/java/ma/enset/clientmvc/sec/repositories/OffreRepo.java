package ma.enset.clientmvc.sec.repositories;

import ma.enset.clientmvc.sec.entities.offreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreRepo extends JpaRepository<offreEntity, Integer > {

    offreEntity findById(int i);
}
