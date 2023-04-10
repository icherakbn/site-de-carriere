package ma.enset.clientmvc.repositories;

import ma.enset.clientmvc.entites.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Page<Client> findByNomContains(String kw, Pageable pageable);
}
