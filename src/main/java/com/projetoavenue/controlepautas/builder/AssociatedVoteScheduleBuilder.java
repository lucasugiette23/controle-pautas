package com.projetoavenue.controlepautas.builder;

import com.projetoavenue.controlepautas.models.AssociatedVoteSchedule;
import com.projetoavenue.controlepautas.models.DTO.AssociatedVoteScheduleDTO;
import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
import com.projetoavenue.controlepautas.models.Schedule;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Component
public class AssociatedVoteScheduleBuilder {

    public AssociatedVoteSchedule AssociatedVoteScheduleDTOfromDTOToEntity(AssociatedVoteScheduleDTO scheduleDTO){
        return AssociatedVoteSchedule.builder()
                .associatedId(scheduleDTO.getAssociatedId())
                .vote(scheduleDTO.getVoto())
                .scheduleId(scheduleDTO.getScheduleId()).build();
    }

}
