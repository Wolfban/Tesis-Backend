package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.provincias.Provincia;
import com.example.tesisbackend.entity.provincias.ProvinciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class provinciaController {

    private final ProvinciaRepository provinciaRepository;

    public provinciaController(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @GetMapping
    public List<Provincia> listar() {
        return provinciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Provincia obtenerUno(@PathVariable Long id) {
        return provinciaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Provincia crear(@RequestBody Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @PutMapping("/{id}")
    public Provincia actualizar(@PathVariable Long id, @RequestBody Provincia datos) {
        return provinciaRepository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            return provinciaRepository.save(p);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        provinciaRepository.deleteById(id);
    }
}
