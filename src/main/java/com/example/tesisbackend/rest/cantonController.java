package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.canton.Canton;
import com.example.tesisbackend.entity.canton.CantonRepository;
import com.example.tesisbackend.entity.sedes.Sede;
import com.example.tesisbackend.entity.sedes.SedeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cantones")
public class cantonController {

    private final CantonRepository cantonRepository;
    private final SedeRepository sedeRepository;

    public cantonController(CantonRepository cantonRepository, SedeRepository sedeRepository) {
        this.cantonRepository = cantonRepository;
        this.sedeRepository = sedeRepository;
    }

    @GetMapping
    public List<Canton> listar() {
        return cantonRepository.findAll();
    }

    @GetMapping("/{id}")
    public Canton obtenerUno(@PathVariable Long id) {
        return cantonRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Canton crear(@RequestBody Canton canton) {
        // canton.provincia debe estar seteada (con ID válido) si quieres guardar la relación
        return cantonRepository.save(canton);
    }

    @PutMapping("/{id}")
    public Canton actualizar(@PathVariable Long id, @RequestBody Canton datos) {
        return cantonRepository.findById(id).map(c -> {
            c.setNombre(datos.getNombre());
            c.setProvincia(datos.getProvincia());
            return cantonRepository.save(c);
        }).orElse(null);
    }
    @GetMapping("/{id}/sedes")
    public List<Sede> getSedes(@PathVariable Long id) {
        return sedeRepository.findByCanton(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cantonRepository.deleteById(id);
    }
}
