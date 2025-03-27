package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.sedes.Sede;
import com.example.tesisbackend.entity.sedes.SedeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class sedeController {

    private final SedeRepository sedeRepository;

    public sedeController(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @GetMapping
    public List<Sede> listar() {
        return sedeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sede obtenerUno(@PathVariable Long id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Sede crear(@RequestBody Sede sede) {
        // sede.canton debe tener un ID existente si quieres enlazarla a un cantón
        return sedeRepository.save(sede);
    }

    @PutMapping("/{id}")
    public Sede actualizar(@PathVariable Long id, @RequestBody Sede datos) {
        return sedeRepository.findById(id).map(s -> {
            s.setNombre(datos.getNombre());
            s.setCanton(datos.getCanton());
            return sedeRepository.save(s);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sedeRepository.deleteById(id);
    }
}

