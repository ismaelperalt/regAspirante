package com.example.Aspirante.Repository;

import com.example.Aspirante.Entity.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante,Long> {

}
