package com.zenika.laposte.bc_preparation.api.rest;

import com.zenika.laposte.bc_preparation.application.CreateEtiquette;
import com.zenika.laposte.bc_preparation.application.EtiquetteDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    public TestController(CreateEtiquette createEtiquette) {
        this.createEtiquette = createEtiquette;
    }

    public  CreateEtiquette createEtiquette ;



    @GetMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void creerEtiquette() {

    }
}
