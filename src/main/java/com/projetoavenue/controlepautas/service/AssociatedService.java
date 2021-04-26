package com.projetoavenue.controlepautas.service;

import com.projetoavenue.controlepautas.models.Associated;
import com.projetoavenue.controlepautas.repository.AssociadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AssociatedService {
    @Autowired
    private AssociadoRepository associadoRepository;

    public ResponseEntity<Associated> registerAssociate(Associated associated){
        log.info("Cadastrando novo associado:", associated.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.associadoRepository.save(associated));
    }
}
