package com.projetoavenue.controlepautas.models.DTO;


import com.projetoavenue.controlepautas.models.enums.ScheduleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociatedVoteScheduleDTO {
    private ScheduleType voto;
    private long associatedId;
    private long scheduleId;
    private String cpf;
}
