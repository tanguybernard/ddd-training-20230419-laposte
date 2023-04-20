package com.zenika.laposte.bc_preparation.application;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisId;

import java.time.LocalDate;
import java.util.UUID;

public class ColisMapper {


    public Colis toDomain(ColisDto dto) {

        return Colis.create(new ColisId(UUID.randomUUID().toString()), LocalDate.now(), dto.expediteurId());
    }

}
