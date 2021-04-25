package com.projetoavenue.controlepautas.builder;

import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
import com.projetoavenue.controlepautas.models.Schedule;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleBuilder {

    public Schedule SchedulefromDTOToEntity(ScheduleDTO scheduleDTO){
      return Schedule.builder().createdDate(LocalDateTime.now())
                .subject(scheduleDTO.getSubject())
                .name(scheduleDTO.getName())
                .cpf(scheduleDTO.getCpf()).build();
    }

}
