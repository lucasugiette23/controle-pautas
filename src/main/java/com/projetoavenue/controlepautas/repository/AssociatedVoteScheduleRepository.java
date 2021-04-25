package com.projetoavenue.controlepautas.repository;

import com.projetoavenue.controlepautas.models.AssociatedVoteSchedule;
import com.projetoavenue.controlepautas.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssociatedVoteScheduleRepository extends JpaRepository<AssociatedVoteSchedule, Long> {
    Optional<AssociatedVoteSchedule> findByAssociatedId(long associatedId);
    Optional<List<AssociatedVoteSchedule>> findByScheduleId(long associatedId);

}
