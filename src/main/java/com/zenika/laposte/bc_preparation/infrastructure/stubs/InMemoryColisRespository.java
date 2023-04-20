package com.zenika.laposte.bc_preparation.infrastructure.stubs;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryColisRespository implements ColisRepository {


    Map<String, Colis> colisMap = new HashMap<>();

    @Override
    public Colis create(Colis colis) {
        String id = colis.id().toString();
        colisMap.put(id, colis);
        return colisMap.get(id);
    }

    @Override
    public Colis getById(ColisId colisId) {
        return colisMap.get(colisId.toString());
    }
}
