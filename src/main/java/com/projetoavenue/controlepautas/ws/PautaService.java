package com.projetoavenue.controlepautas.ws;


import com.projetoavenue.controlepautas.models.Pauta;
import com.projetoavenue.controlepautas.models.VotarPautaRequest;
import com.projetoavenue.controlepautas.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    public ResponseEntity<?> votarPauta(VotarPautaRequest votarPautaRequest){
       var pauta = Pauta.builder().dataVoto(LocalDateTime.now())
                .id_associado(votarPautaRequest.getIdAssociado())
                .voto(votarPautaRequest.getVoto()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pautaRepository.save(pauta));
    }
}
