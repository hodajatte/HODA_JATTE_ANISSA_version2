package com.example.hoda_jatte_anissa.Repository;
import com.example.hoda_jatte_anissa.Entity.Encadrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncadrantRepository extends JpaRepository<Encadrant, Long> {

}
