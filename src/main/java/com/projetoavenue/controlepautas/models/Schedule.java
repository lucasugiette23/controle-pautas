package com.projetoavenue.controlepautas.models;


import com.projetoavenue.controlepautas.models.enums.ScheduleType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pauta")
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private String subject;
    private String cpf;
    private Boolean openedSession;
}
