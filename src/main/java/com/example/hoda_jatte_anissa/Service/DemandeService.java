package com.example.hoda_jatte_anissa.Service;

import com.example.hoda_jatte_anissa.Entity.Demande;
import org.springframework.core.io.Resource;

import java.time.LocalDate;
import java.util.List;

public interface DemandeService {
    List<Demande> getAllDemandes();
    void saveDemande(Demande demande);
    Demande getDemandeById(Long id);
    void deleteDemande(Long id);
    void accepterDemande(Long demandeId, LocalDate dateDebut, LocalDate dateFin);
    void refuserDemande(Long demandeId);
    void mettreEnAttente(Long demandeId);

    Resource loadCVFile(Demande demande);

    Resource loadLettreFile(Demande demande);
    // Ajoutez d'autres méthodes nécessaires
}

