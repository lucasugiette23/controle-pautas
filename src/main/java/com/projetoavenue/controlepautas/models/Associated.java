package com.projetoavenue.controlepautas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Associado")
public class Associated {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String doc;
    private String birthdate;
}
