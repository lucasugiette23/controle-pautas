package com.projetoavenue.controlepautas.controller;


import com.projetoavenue.controlepautas.models.Associated;
import com.projetoavenue.controlepautas.service.AssociatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associated")
public class AssociateController {
    @Autowired
    private AssociatedService associatedService;

    @PostMapping(value = "/registerAssociate")
    public ResponseEntity<?> registerAssociate(@RequestBody Associated associated){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(associatedService.registerAssociate(associated));
    }

}
