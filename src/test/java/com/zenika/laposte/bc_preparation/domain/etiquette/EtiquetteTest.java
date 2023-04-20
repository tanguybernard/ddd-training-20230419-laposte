package com.zenika.laposte.bc_preparation.domain.etiquette;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class EtiquetteTest {


    @Test
     void createEtiquette() {

        //Given
        EtiquetteId id = new EtiquetteId(UUID.randomUUID().toString());
        Dimension dimension = new Dimension(3,4,5);
        Poids poids = new Poids(25, "g");

        //WHEN
        Etiquette etiquette = Etiquette.create(id, poids, dimension);

        //THEN
        assertEquals(id, etiquette.getId());
        assertEquals(25, etiquette.poids.valeur);
        assertEquals(dimension, etiquette.dimension);

    }
}
