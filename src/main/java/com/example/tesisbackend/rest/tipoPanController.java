package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.pan.TipoPan;
import com.example.tesisbackend.entity.pan.TipoPanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-pan")
public class tipoPanController {

    private final TipoPanRepository tipoPanRepository;

    public tipoPanController(TipoPanRepository tipoPanRepository) {
        this.tipoPanRepository = tipoPanRepository;
    }

    @GetMapping
    public List<TipoPan> listar() {
        return tipoPanRepository.findAll();
    }

    @GetMapping("/{id}")
    public TipoPan obtenerUno(@PathVariable Long id) {
        return tipoPanRepository.findById(id).orElse(null);
    }

    @PostMapping
    public TipoPan crear(@RequestBody TipoPan tipoPan) {
        return tipoPanRepository.save(tipoPan);
    }

    @PutMapping("/{id}")
    public TipoPan actualizar(@PathVariable Long id, @RequestBody TipoPan datos) {
        return tipoPanRepository.findById(id).map(tp -> {
            tp.setTipo(datos.getTipo());
            return tipoPanRepository.save(tp);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tipoPanRepository.deleteById(id);
    }
}
