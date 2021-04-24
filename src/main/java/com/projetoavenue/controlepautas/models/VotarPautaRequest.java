package com.projetoavenue.controlepautas.models;


import com.projetoavenue.controlepautas.models.enums.PautaType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotarPautaRequest {
    private PautaType voto;
    private long idAssociado;

}
