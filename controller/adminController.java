package ma.enset.careerwebsite.controller;

import ma.enset.careerwebsite.entity.AddOfferAdmin;
import ma.enset.careerwebsite.model.DeleteOfferModel;
import ma.enset.careerwebsite.repository.addOfferAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class adminController {
    @Autowired
    private addOfferAdminRepository addOfferAdminRepository;

    @PostMapping("/addoffer")
    public String addOffer(
            @ModelAttribute AddOfferAdmin addOfferAdmin,
            Model model
            ){
        AddOfferAdmin savedoffer = addOfferAdminRepository.saveAndFlush(addOfferAdmin);
        if(savedoffer==null){
            model.addAttribute("errors","error occured");
        }else{
            model.addAttribute("errors","goude");
        }
        return "adminoffers";
    }

    @PostMapping("/deleteoffer")
    public String deleteOffer(
            @ModelAttribute DeleteOfferModel deleteOfferModel,
            Model model
    ){
        System.out.println(deleteOfferModel.getOffer());
        return "adminoffers";
    }

    @GetMapping("/adminoffers")
    public String getAdminOffer(
             Model model

    ){
        List<AddOfferAdmin> offers = addOfferAdminRepository.findAll();
        model.addAttribute("offerslist",offers);
        return "adminoffers";
    }
}
