package com.projetoavenue.controlepautas.models;

import com.projetoavenue.controlepautas.models.enums.ScheduleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pauta_associado")
public class AssociatedVoteSchedule {
    @Id
    @GeneratedValue
    private long id;
    private long associatedId;
    private long scheduleId;
    private ScheduleType vote;
}
