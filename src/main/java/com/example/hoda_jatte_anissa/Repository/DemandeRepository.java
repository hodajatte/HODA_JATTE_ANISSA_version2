package com.example.hoda_jatte_anissa.Repository;

import com.example.hoda_jatte_anissa.Entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
