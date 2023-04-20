package com.zenika.laposte.bc_preparation.domain.etiquette;

import com.zenika.laposte.shared_kernel.AggregateRoot;

public class Etiquette extends AggregateRoot<EtiquetteId> {

    public final Poids poids;
    public Dimension dimension;

    private Etiquette(EtiquetteId id, Poids poids, Dimension dimension){
        super(id);
        this.poids = poids;
        this.dimension = dimension;
    }

    static Etiquette create(EtiquetteId id, Poids poids, Dimension dimension) {
        //rules

        //this.record(new EtiquettePréparé);
        return new Etiquette(id, poids, dimension);
    }

    static Etiquette load(EtiquetteId id, Poids poids, Dimension dimension) {
        //rules
        return new Etiquette(id, poids, dimension);
    }
}
