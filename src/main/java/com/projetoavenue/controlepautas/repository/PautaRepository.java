package com.projetoavenue.controlepautas.repository;

import com.projetoavenue.controlepautas.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Schedule, Long> {
}
