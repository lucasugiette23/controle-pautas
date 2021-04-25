package com.projetoavenue.controlepautas.models;

import lombok.Data;

@Data
public class ResultSchedule {
    private String pauta;
    private long VotosSim;
    private long votosNão;
}
