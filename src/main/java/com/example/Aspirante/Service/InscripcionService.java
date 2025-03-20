package com.example.Aspirante.Service;

import com.example.Aspirante.Entity.Aspirante;
import com.example.Aspirante.Entity.Carrera;
import com.example.Aspirante.Entity.Colegio;
import com.example.Aspirante.Entity.Inscripcion;
import com.example.Aspirante.Repository.AspiranteRepository;
import com.example.Aspirante.Repository.CarreraRepository;
import com.example.Aspirante.Repository.ColegioRepository;
import com.example.Aspirante.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InscripcionService {

    @Autowired
    private AspiranteRepository aspiranteRepository;
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public double calcularValorInscripcion(Colegio colegio) {
        if (colegio == null || colegio.getTipo() == null) {
            throw new IllegalArgumentException("El colegio o su tipo son nulos");
        }

        double valorBase = 100.0;
        if ("Fiscal".equals(colegio.getTipo()) || "Fiscomisional".equals(colegio.getTipo())) {
            return valorBase * 0.97; // Aplica descuento del 3%
        }
        return valorBase;
    }

    public void registrarInscripcion(Aspirante aspirante, Carrera carrera) {
        if (aspirante.getColegio() == null) {
            throw new IllegalArgumentException("El aspirante debe tener un colegio asignado");
        }

        double valorInscripcion = calcularValorInscripcion(aspirante.getColegio());
        aspirante.setValorInscripcion(valorInscripcion);
        aspirante.setCarrera(carrera);
        aspiranteRepository.save(aspirante);

        carrera.setNumeroDeEstudiantes(carrera.getNumeroDeEstudiantes() + 1);
        carreraRepository.save(carrera);

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAspirante(aspirante);
        inscripcion.setCarrera(carrera);
        inscripcion.setMontoPagado(valorInscripcion);
        inscripcionRepository.save(inscripcion);
    }
}
