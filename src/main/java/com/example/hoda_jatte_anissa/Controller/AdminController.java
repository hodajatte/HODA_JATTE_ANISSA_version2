package com.example.hoda_jatte_anissa.Controller;
import com.example.hoda_jatte_anissa.Entity.DemandeEtat;
import com.example.hoda_jatte_anissa.Service.DemandeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import com.example.hoda_jatte_anissa.Entity.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Controller
public class AdminController {
    @Autowired
    private DemandeService demandeService;
    @GetMapping("/demandes")
    public String listDemandes(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("userRole", userRole);
        model.addAttribute("username", username);
        List<Demande> demandes = demandeService.getAllDemandes();
        model.addAttribute("demandes", demandes);
        return "demandes";
    }

    @PostMapping("/demande/{demandeId}/accepter")
    public String accepterDemande(@PathVariable Long demandeId) {
        demandeService.accepterDemande(demandeId);
        return "redirect:/demandes";
    }

    @PostMapping("/demande/{demandeId}/refuser")
    public String refuserDemande(@PathVariable Long demandeId) {
        demandeService.refuserDemande(demandeId);
        return "redirect:/demandes";
    }

    @PostMapping("/demande/{demandeId}/attente")
    public String mettreEnAttente(@PathVariable Long demandeId) {
        demandeService.mettreEnAttente(demandeId);
        return "redirect:/demandes";
    }

    @GetMapping("/demandes-acceptees")
    public String getDemandesAcceptees(Model model) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();

        model.addAttribute("userRole", userRole);
        model.addAttribute("username", username);
        List<DemandeEtat> demandesAcceptees = demandeService.getDemandesAcceptees();
        model.addAttribute("demandesAcceptees", demandesAcceptees);
        return "demandes_acceptees";
    }
    @GetMapping("/demandes-refusees")
    public String getDemandesRefusees(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();

        model.addAttribute("userRole", userRole);
        model.addAttribute("username", username);
        List<DemandeEtat> demandesRefusees = demandeService.getDemandesRefusees();
        model.addAttribute("demandesRefusees", demandesRefusees);
        return "demandes_refusees";
    }

    @GetMapping("/demandes-en-attente")
    public String getDemandesEnAttente(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();

        model.addAttribute("userRole", userRole);
        model.addAttribute("username", username);
        List<DemandeEtat> demandesEnAttente = demandeService.getDemandesEnAttente();
        model.addAttribute("demandesEnAttente", demandesEnAttente);
        return "demandes_en_attente";
    }
}