package com.zenika.laposte.bc_preparation.domain.colis;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ColisTest {


    @Test
     void createColisShouldGenerateIdAndCreationDate() {
        //Given
        ColisId colisId = new ColisId(UUID.randomUUID().toString());

        //WHEN
        Colis colis = new Colis(colisId, LocalDate.now()) ;
        //THEN
        assertNotNull(colis.id());
        assertNotNull(colis.dateDeCreation());
    }
}
