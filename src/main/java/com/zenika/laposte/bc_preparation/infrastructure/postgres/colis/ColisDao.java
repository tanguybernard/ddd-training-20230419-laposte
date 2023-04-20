package com.zenika.laposte.bc_preparation.infrastructure.postgres.colis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColisDao extends JpaRepository<ColisEntity, String> {
}
