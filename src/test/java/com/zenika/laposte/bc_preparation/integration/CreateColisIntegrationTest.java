package com.zenika.laposte.bc_preparation.integration;

import com.zenika.laposte.bc_preparation.application.ColisDto;
import com.zenika.laposte.bc_preparation.application.ColisMapper;
import com.zenika.laposte.bc_preparation.application.CreateColis;
import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateColisIntegrationTest {


    @Autowired
    ColisRepository colisRepository;

    @Test
    void createColis() throws Exception {
        // GIVEN
        ColisDto colisDto =  new ColisDto("1");
        ColisMapper mapper = new ColisMapper();
        //WHEN
          CreateColis createColis = new CreateColis(colisRepository,mapper) ;
          Colis colis = createColis.execute(colisDto);
        //THEN
        assertNotNull(colis);
        assertNotNull(colis.id());
        assertNotNull(colis.dateDeCreation());

        assertEquals(colis.id().toString(), this.colisRepository.getById(colis.id()).id().toString());

    }
}
