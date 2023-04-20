package com.zenika.laposte.bc_preparation.infrastructure.colis.postgres;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;

import java.util.Optional;

public class PgColisRepository implements ColisRepository {
    private ColisDao dao;

    public PgColisRepository(ColisDao dao) {

        this.dao = dao;
    }

    @Override
    public Colis create(Colis colis) {

        ColisEntity e = new ColisEntity();
        e.id = colis.id().toString();
        e.dateDeCreation = colis.dateDeCreation();
        e.expediteurId = colis.expediteurId;

        ColisEntity colisSaved = dao.save(e);

        return colis;
    }

    @Override
    public Colis getById(ColisId colisId) throws Exception {
        Optional<ColisEntity> entity = this.dao.findById(colisId.toString());
        if(entity.isPresent()){
            ColisEntity e = entity.get();
            return Colis.load(new ColisId(e.id), e.dateDeCreation, e.expediteurId);
        }
        throw new Exception("Colis not there");
    }
}
