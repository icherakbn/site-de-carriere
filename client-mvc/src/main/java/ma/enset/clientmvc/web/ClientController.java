package ma.enset.clientmvc.web;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.clientmvc.entites.Client;
import ma.enset.clientmvc.repositories.ClientRepository;
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

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientRepository clientRepository;

    @GetMapping(path = "/index")
    public String clients(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword
    ){
        Page<Client> pageClients = clientRepository.findByNom(keyword, PageRequest.of(page, size));
        model.addAttribute("listClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("status", keyword);
        return "clients";

    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page) {
        clientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/clients")
    @ResponseBody
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/formClients")
    public String formClients(Model model){
        model.addAttribute("client",new Client());
        return "formClients";
    }

    @PostMapping(path="/save")
    public String save(Model model, @Valid Client client, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "formClients";
        clientRepository.save(client);
        return "redirect:/formClients";
    }

    @GetMapping("/editClients")
    public String editClients(Model model,Long id){
        Client client=clientRepository.findById(id).orElse(null);
        if(client==null) throw new RuntimeException("Client introuvable");
        model.addAttribute("client",new Client());
        return "formClients";
    }
}
