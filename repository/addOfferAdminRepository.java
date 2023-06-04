package ma.enset.careerwebsite.repository;

import ma.enset.careerwebsite.entity.AddOfferAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface addOfferAdminRepository extends JpaRepository<AddOfferAdmin, Long> {

}
