package com.projetoavenue.controlepautas.service;

import com.projetoavenue.controlepautas.models.Associated;
import com.projetoavenue.controlepautas.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository associadoRepository;

    public ResponseEntity<?> registerAssociate(Associated associated){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.associadoRepository.save(associated));
    }
}
