package com.example.hoda_jatte_anissa.Controller;

import com.example.hoda_jatte_anissa.Repository.DemandeEtatRepository;
import com.example.hoda_jatte_anissa.Service.DemandeService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import com.example.hoda_jatte_anissa.Entity.Demande;
import com.example.hoda_jatte_anissa.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DemandeService demandeService;


    @GetMapping("/demande/{demandeId}/download-cv")
    public ResponseEntity<Resource> downloadCV(@PathVariable Long demandeId) {
        Demande demande = demandeService.getDemandeById(demandeId);
        Resource cvFile = demandeService.loadCVFile(demande);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cvFile.getFilename() + "\"")
                .body(cvFile);
    }

    @GetMapping("/demande/{demandeId}/download-lettre")
    public ResponseEntity<Resource> downloadLettre(@PathVariable Long demandeId) {
        Demande demande = demandeService.getDemandeById(demandeId);
        Resource lettreFile = demandeService.loadLettreFile(demande);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + lettreFile.getFilename() + "\"")
                .body(lettreFile);
    }

    @GetMapping("/demandes")
    public String listDemandes(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("userRole", userRole);
        model.addAttribute("username", username);
        List<Demande> demandes = demandeService.getAllDemandes();
        model.addAttribute("demandes", demandes);
        return "admin/demandes";
    }

    @PostMapping("/demande/{demandeId}/accepter")
    public String accepterDemande(@PathVariable Long demandeId, LocalDate date_Debut, LocalDate date_Fin) {
        demandeService.accepterDemande(demandeId, date_Debut, date_Fin);
        return "redirect:/admin/demandes";
    }

    @PostMapping("/demande/{demandeId}/refuser")
    public String refuserDemande(@PathVariable Long demandeId) {
        demandeService.refuserDemande(demandeId);
        return "redirect:/admin/demandes";
    }

    @PostMapping("/demande/{demandeId}/attente")
    public String mettreEnAttente(@PathVariable Long demandeId) {
        demandeService.mettreEnAttente(demandeId);
        return "redirect:/admin/demandes";
    }




}