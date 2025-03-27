package com.example.tesisbackend.entity.pan;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CaducidadSchedule {
    private final PanPanaderiaRepository repository;

    public CaducidadSchedule(PanPanaderiaRepository repository) {
        this.repository = repository;
    }


    @Scheduled(fixedRate = 30000)
    public void revisarCaducados() {
        LocalDateTime ahora = LocalDateTime.now();
        List<PanPanaderia> lista = repository.findByYaCadFalseAndFechaCadBefore(1L, LocalDateTime.now());;

        for (PanPanaderia pp : lista) {
            pp.setYaCad(true);
        }
        if (!lista.isEmpty()) {
            repository.saveAll(lista);
            System.out.println("Marcados como caducados: " + lista.size());
        }
    }
}
