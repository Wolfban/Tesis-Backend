package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.pan.Pan;
import com.example.tesisbackend.entity.pan.PanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panes")
public class panController {

    private final PanRepository panRepository;

    public panController(PanRepository panRepository) {
        this.panRepository = panRepository;
    }

    @GetMapping
    public List<Pan> listar() {
        return panRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pan obtenerUno(@PathVariable Long id) {
        return panRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pan crear(@RequestBody Pan pan) {
        // pan.tipoPan debe tener un ID válido si se asocia a un tipo
        return panRepository.save(pan);
    }

    @PutMapping("/{id}")
    public Pan actualizar(@PathVariable Long id, @RequestBody Pan datos) {
        return panRepository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setTipo(datos.getTipo());
            return panRepository.save(p);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        panRepository.deleteById(id);
    }
}
