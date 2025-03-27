package com.example.tesisbackend.rest;

import com.example.tesisbackend.entity.pan.Pan;
import com.example.tesisbackend.entity.pan.PanPanaderia;
import com.example.tesisbackend.entity.pan.PanPanaderiaRepository;
import com.example.tesisbackend.entity.pan.PanRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pan-panaderia")
public class PanPanaderiaController {

    private final PanPanaderiaRepository repository;
    private final PanPanaderiaRepository panPanaderiaRepository;
    private final PanRepository panRepository;

    public PanPanaderiaController(PanPanaderiaRepository repository, PanPanaderiaRepository panPanaderiaRepository, PanRepository panRepository) {
        this.repository = repository;
        this.panPanaderiaRepository = panPanaderiaRepository;
        this.panRepository = panRepository;
    }

    @GetMapping
    public List<PanPanaderia> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PanPanaderia obtenerUno(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public PanPanaderia crear(@RequestBody PanPanaderia registro) {
        Pan pan = panRepository.findById(Long.valueOf(registro.getPan().getIdPan())).orElseThrow();
        int horas = pan.getTipoPan().getDuracionHoras();
        LocalDateTime cad = LocalDateTime.now().plusHours(horas);
        registro.setFechaCad(cad);
        
        return repository.save(registro);
    }

    @PutMapping("/{id}")
    public PanPanaderia actualizar(@PathVariable Long id, @RequestBody PanPanaderia datos) {
        return repository.findById(id).map(pp -> {
            pp.setPanaderia(datos.getPanaderia());
            pp.setPan(datos.getPan());
            pp.setCant(datos.getCant());
            pp.setFechaCad(datos.getFechaCad());
            return repository.save(pp);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/historial/{panaderiaId}")
    public List<PanPanaderia> historial(@PathVariable Long panaderiaId) {
        return repository.findHistorialByPanaderia(panaderiaId);
    }


    @GetMapping("/caducados/{panaderiaId}")
    public List<PanPanaderia> caducados(@PathVariable Long panaderiaId) {

        LocalDateTime ahora = LocalDateTime.now();
        return repository.findByYaCadFalseAndFechaCadBefore(panaderiaId, ahora);
    }



}
