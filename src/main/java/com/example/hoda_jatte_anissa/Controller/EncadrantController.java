package com.example.hoda_jatte_anissa.Controller;

import com.example.hoda_jatte_anissa.Entity.Encadrant;
import com.example.hoda_jatte_anissa.Service.EncadrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncadrantController {

    @Autowired
    private EncadrantService encadrantService;

    @GetMapping("/encadrants")
    public String showDemandeStageForm(Model model) {
        model.addAttribute("encadrant", new Encadrant());
        return "encadrants"; // Assurez-vous que le nom du modèle correspond à votre template Thymeleaf
    }

    @PostMapping("/encadrants")
    public String submitDemandeStageForm(@ModelAttribute("encadrant") Encadrant encadrant) {
        // Traitez les données du formulaire et enregistrez-les dans la base de données via le service
        encadrantService.saveEncadrant(encadrant);

        // Redirigez vers la page de demande de stage avec un paramètre de succès
        return "redirect:/encadrants?success=true";
    }
}
