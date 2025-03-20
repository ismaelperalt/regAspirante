package com.example.Aspirante.Controller;

import com.example.Aspirante.Entity.Aspirante;
import com.example.Aspirante.Entity.Carrera;
import com.example.Aspirante.Entity.Colegio;
import com.example.Aspirante.Repository.CarreraRepository;
import com.example.Aspirante.Repository.ColegioRepository;
import com.example.Aspirante.Service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;
    @Autowired
    private ColegioRepository colegioRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    // Endpoint para calcular el valor de la inscripción antes de confirmar
    @GetMapping("/calcular-inscripcion")
    public ResponseEntity<Map<String, Object>> calcularValorInscripcion(@RequestParam Long colegioId) {
        Colegio colegio = colegioRepository.findById(colegioId)
                .orElseThrow(() -> new RuntimeException("Colegio no encontrado"));

        double valorInscripcion = inscripcionService.calcularValorInscripcion(colegio);

        Map<String, Object> response = new HashMap<>();
        response.put("colegio", colegio.getNombre());
        response.put("valorInscripcion", valorInscripcion);

        return ResponseEntity.ok(response);
    }

    // Endpoint para registrar la inscripción después de la confirmación
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarInscripcion(
            @RequestParam Long colegioId,
            @RequestParam Long carreraId,
            @RequestBody Aspirante aspirante) {

        Colegio colegio = colegioRepository.findById(colegioId)
                .orElseThrow(() -> new RuntimeException("Colegio no encontrado"));

        Carrera carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        aspirante.setColegio(colegio);
        inscripcionService.registrarInscripcion(aspirante, carrera);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
