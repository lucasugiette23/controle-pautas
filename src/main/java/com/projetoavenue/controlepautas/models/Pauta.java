package com.projetoavenue.controlepautas.models;


import com.projetoavenue.controlepautas.models.enums.PautaType;
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
public class Pauta {
    @Id
    @GeneratedValue
    private Long id;
    private PautaType voto;
    private long id_associado;
    private LocalDateTime dataVoto;
}
