package com.projetoavenue.controlepautas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Authorization {
    private String type;
    private String token;

    public String getTokenDescriptor(){
        return this.type.concat(" ".concat(this.token));
    }
}
