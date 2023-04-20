package com.zenika.laposte.bc_preparation.configuraiton;

import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import com.zenika.laposte.bc_preparation.infrastructure.colis.postgres.ColisDao;
import com.zenika.laposte.bc_preparation.infrastructure.colis.postgres.PgColisRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreparationConfiguration {


    @Bean
    ColisRepository colisRepository(ColisDao dao) {
        return new PgColisRepository(dao);
    }


}
