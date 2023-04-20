package com.zenika.laposte.bc_preparation.application;

import com.zenika.laposte.bc_preparation.infrastructure.colis.stubs.InMemoryColisRespository;
import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateColisTest {

    @Test
    void createColis() {
        // GIVEN
        ColisDto colisDto =  new ColisDto("1");
        ColisMapper mapper = new ColisMapper();
        ColisRepository repository = new InMemoryColisRespository();
        //WHEN
          CreateColis createColis = new CreateColis(repository,mapper) ;
          Colis colis = createColis.execute(colisDto);
        //THEN
        assertNotNull(colis);
        assertNotNull(colis.id());
        assertNotNull(colis.dateDeCreation());

    }
}
