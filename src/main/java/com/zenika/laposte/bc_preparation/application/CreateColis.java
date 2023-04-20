package com.zenika.laposte.bc_preparation.application;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;

public class CreateColis {

    private ColisMapper colisMapper  ;
  private  ColisRepository colisRepository ;

    public CreateColis(ColisRepository colisRepository, ColisMapper colisMapper) {
        this.colisMapper = colisMapper;
        this.colisRepository = colisRepository;
    }


    public Colis execute(ColisDto colisDto) {
        Colis colis = colisMapper.toDomain(colisDto);
        return colisRepository.create(colis) ;
    }
}
