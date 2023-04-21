package com.zenika.laposte.bc_preparation.infrastructure.postgres.etiquette;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetteDao extends JpaRepository<EtiquetteEntity, String> {
}
