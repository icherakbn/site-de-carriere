package ma.enset.clientmvc.sec.service;

import ma.enset.clientmvc.sec.entities.AppUser;
import ma.enset.clientmvc.sec.entities.offreEntity;
import ma.enset.clientmvc.sec.repositories.OffreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class OffreService {
    @Autowired
    OffreRepo offrerepo;
    public void createoffre(AppUser client){

    }
    public void updateoffre(AppUser client){

    }
    public void disabledOffre(int Id){
        offreEntity offreEntity=offrerepo.findById(Id);
        if(offreEntity==null){
            System.out.println("impossible de trouver un offre");
        }
        else{
            offreEntity.setDisabled(1);
            offreEntity offreEntity1 = offrerepo.save(offreEntity);
            System.out.println(offreEntity1);
        }
    }
}
