package ma.enset.clientmvc.web;


import javax.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.clientmvc.entites.Client;
import ma.enset.clientmvc.repositories.ClientRepository;
import ma.enset.clientmvc.sec.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

@Controller
@AllArgsConstructor
public class ClientController {
    @Autowired
    OffreService offreService;
    private ClientRepository clientRepository;

    @PostMapping(path = "/user/index")
    public String clients(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", required = false) String keyword
    ){
        if (keyword != null){
        Page<Client> pageClients = clientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("status", keyword);
        }
       /* for ( Client c : pageClients.getContent()){
            System.out.println(c.getNom());
            System.out.println(c.getPrenom());
        }*/
        return "clients";

    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page) {
        clientRepository.deleteById(id);
        return "redirect:/user/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user/clients")
    @ResponseBody
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/admin/formClients")
    public String formClients(Model model){
        model.addAttribute("client",new Client());
        return "formClients";
    }

    @PostMapping(path="/admin/save")
    public String save(Model model, @Valid Client client, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formClients";
        Client c = clientRepository.save(client);
        System.out.println(page);
        System.out.println(keyword);
        if(keyword==NULL){
            System.out.println("keyword is null");
        }
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editClients ")
    public String editClients(Model model,@RequestParam  Long id,
                              @RequestParam String keyword,
                              @RequestParam int page){
        Client client=clientRepository.findById(id).orElse(null);
        if(client==null) throw new RuntimeException("Client introuvable");
        model.addAttribute("client",/*new*/client/*Client()*/);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editClients";
    }

    @GetMapping ("/delete")
    public String deleteoffre(@RequestParam int Id){
        offreService.disabledOffre(Id);
        return "home";
    }

}
