package com.projetoavenue.controlepautas.models;

import lombok.Data;

@Data
public class OpenSessionInSchedule {
    private long idSchedule;
    private long timeWithSessionStayOpen;
    private String cpf;
}
