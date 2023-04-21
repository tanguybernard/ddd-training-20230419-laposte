package com.zenika.laposte.bc_preparation.domain.etiquette;

public interface EtiquetteRepository {

    Etiquette getEtiquetteBy(EtiquetteId etiquetteId) throws Exception;
    void create(Etiquette etiquette);

}
