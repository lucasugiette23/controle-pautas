package com.projetoavenue.controlepautas.repository;

import com.projetoavenue.controlepautas.models.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
