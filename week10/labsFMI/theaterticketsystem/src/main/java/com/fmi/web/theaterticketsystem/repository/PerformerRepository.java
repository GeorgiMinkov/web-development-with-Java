package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer, Long> {
}
