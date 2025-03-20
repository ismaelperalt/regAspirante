package com.example.Aspirante.Repository;

import com.example.Aspirante.Entity.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio,Long> {

}
