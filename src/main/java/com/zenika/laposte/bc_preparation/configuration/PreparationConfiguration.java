package com.zenika.laposte.bc_preparation.configuration;

import com.zenika.laposte.bc_preparation.application.CreateEtiquette;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import com.zenika.laposte.bc_preparation.domain.etiquette.EtiquetteRepository;
import com.zenika.laposte.bc_preparation.infrastructure.postgres.colis.ColisDao;
import com.zenika.laposte.bc_preparation.infrastructure.postgres.colis.PgColisRepository;
import com.zenika.laposte.bc_preparation.infrastructure.postgres.etiquette.EtiquetteDao;
import com.zenika.laposte.bc_preparation.infrastructure.postgres.etiquette.PgEtiquetteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreparationConfiguration {


    @Bean
    ColisRepository colisRepository(ColisDao dao) {
        return new PgColisRepository(dao);
    }

    @Bean
    EtiquetteRepository etiquetteRepository(EtiquetteDao dao) {
        return new PgEtiquetteRepository(dao);
    }

    @Bean
    CreateEtiquette createEtiquette(EtiquetteRepository etiquetteRepository) {
        return new CreateEtiquette(etiquetteRepository);
    }


}
