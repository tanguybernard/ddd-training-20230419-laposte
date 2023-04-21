package com.zenika.laposte.bc_preparation.infrastructure.postgres.etiquette;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import com.zenika.laposte.bc_preparation.domain.etiquette.*;

import java.util.Optional;

public class PgEtiquetteRepository implements EtiquetteRepository {
    private EtiquetteDao dao;

    public PgEtiquetteRepository(EtiquetteDao dao) {

        this.dao = dao;
    }

    @Override
    public void create(Etiquette etiquette) {

        EtiquetteEntity e = new EtiquetteEntity();
        e.id = etiquette.getId().toString();
        dao.save(e);
    }

    @Override
    public Etiquette getEtiquetteBy(EtiquetteId etiquetteId) throws Exception {
        Optional<EtiquetteEntity> entity = this.dao.findById(etiquetteId.toString());
        if(entity.isPresent()){
            EtiquetteEntity e = entity.get();
            return Etiquette.create(new EtiquetteId(e.id), new Poids(e.poids, "g"), new Dimension(e.dimensionLongueur, e.dimensionLargeur, e.dimensionProfondeur));
        }
        throw new Exception("Etiquette not there");
    }
}
