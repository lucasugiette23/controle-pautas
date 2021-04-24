package com.projetoavenue.controlepautas.controller;


import com.projetoavenue.controlepautas.models.Associado;
import com.projetoavenue.controlepautas.ws.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associated")
public class AssociadoController {
    @Autowired
    private AssociadoService associadoService;

    @PostMapping(value = "/registerAssociate")
    public ResponseEntity<?> votarPauta(@RequestBody Associado associado){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(associadoService.registerAssociate(associado));
    }

}
