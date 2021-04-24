package com.projetoavenue.controlepautas.ws;

import com.projetoavenue.controlepautas.models.Associado;
import com.projetoavenue.controlepautas.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository associadoRepository;

    public ResponseEntity<?> registerAssociate(Associado associado){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.associadoRepository.save(associado));
    }
}
