package com.zenika.laposte.bc_preparation.domain.colis;

public interface ColisRepository {

    Colis create(Colis colis);

    Colis getById(ColisId colisId) throws Exception;
}
