package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.canton.Canton;
import com.example.tesisbackend.entity.canton.CantonRepository;
import com.example.tesisbackend.entity.provincias.Provincia;
import com.example.tesisbackend.entity.provincias.ProvinciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class provinciaController {

    private final ProvinciaRepository provinciaRepository;
    private final CantonRepository cantonRepository;

    public provinciaController(ProvinciaRepository provinciaRepository, CantonRepository cantonRepository) {
        this.provinciaRepository = provinciaRepository;
        this.cantonRepository = cantonRepository;
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

    @GetMapping("/{id}/cantones")
    public List<Canton> getCantones(@PathVariable Long id) {
        return cantonRepository.findByProvinciaIdProvincia(id);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        provinciaRepository.deleteById(id);
    }
}
