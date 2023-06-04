package ma.enset.careerwebsite.controller;

import ma.enset.careerwebsite.entity.Offer;
import ma.enset.careerwebsite.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    @RequestMapping("/")
    public String index() {
        return "form";
    }

    @PostMapping("/submit")
    public String submitOffer(
            @RequestBody Offer offer,
            Model model
    ) {
        Offer savedOffer = offerRepository.save(offer);
        if (savedOffer == null) {
            model.addAttribute("errors", "Error has been occured");
            return "form";
        }
        else{
        return "home";
        }

    }
}


