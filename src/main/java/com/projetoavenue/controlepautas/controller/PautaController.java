package com.projetoavenue.controlepautas.controller;


import com.projetoavenue.controlepautas.models.VotarPautaRequest;
import com.projetoavenue.controlepautas.ws.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public class PautaController {
    @Autowired
    PautaService pautaService;

    @PostMapping(value = "/votarPauta")
    public ResponseEntity<?> votarPauta(@RequestBody VotarPautaRequest votarPautaRequest){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pautaService.votarPauta(votarPautaRequest));
    }



}
