package com.zenika.laposte.bc_preparation.api.rest;

import com.zenika.laposte.bc_preparation.application.CreateEtiquette;
import com.zenika.laposte.bc_preparation.application.EtiquetteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colis")
public class EtiquetteController {

    public EtiquetteController(CreateEtiquette createEtiquette) {
        this.createEtiquette = createEtiquette;
    }

    public  CreateEtiquette createEtiquette ;



    @PostMapping("/{idColis}/etiquette")
    public ResponseEntity<Object> creerEtiquette(@PathVariable String idColis , @RequestBody EtiquetteDto etiquetteDto) {
        createEtiquette.execute(etiquetteDto , idColis);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
