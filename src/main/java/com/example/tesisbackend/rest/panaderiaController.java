package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.panaderia.Panaderia;
import com.example.tesisbackend.entity.panaderia.PanaderiaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/panaderias")
public class panaderiaController {

    private final PanaderiaRepository panaderiaRepository;

    public panaderiaController(PanaderiaRepository panaderiaRepository) {
        this.panaderiaRepository = panaderiaRepository;
    }
    @GetMapping
    public List<Panaderia> listar() {
        return panaderiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Panaderia obtenerUno(@PathVariable Long id) {
        return panaderiaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Panaderia crear(@RequestBody Panaderia panaderia) {
        return panaderiaRepository.save(panaderia);
    }

    @PutMapping("/{id}")
    public Panaderia actualizar(@PathVariable Long id, @RequestBody Panaderia datos) {
        return panaderiaRepository.findById(id).map(panad -> {
            panad.setNombre(datos.getNombre());
            panad.setSede(datos.getSede());
            return panaderiaRepository.save(panad);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        panaderiaRepository.deleteById(id);
    }

    @GetMapping("/por-sede/{sedeId}")
    public List<Panaderia> listarPorSede(@PathVariable Long sedeId) {
        return panaderiaRepository.findBySedeId(sedeId);
    }
}
