package com.projetoavenue.controlepautas.controller;


import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
import com.projetoavenue.controlepautas.models.DTO.AssociatedVoteScheduleDTO;
import com.projetoavenue.controlepautas.models.OpenSessionInSchedule;
import com.projetoavenue.controlepautas.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    PautaService pautaService;

    @PostMapping(value = "/newSchedule")
    public ResponseEntity<?> newSchedule(@RequestBody ScheduleDTO scheduleDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pautaService.newSchedule(scheduleDTO));
    }

    @PostMapping(value = "/votarPauta")
    public ResponseEntity<?> votarPauta(@RequestBody AssociatedVoteScheduleDTO associatedVoteScheduleDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pautaService.votarPauta(associatedVoteScheduleDTO));
    }

    @PostMapping(value = "/openSessionInSchedule")
    public void openSessionInSchedule(@RequestBody OpenSessionInSchedule openSessionInSchedule){
       pautaService.openSessionInShcedule(openSessionInSchedule);
    }
    @GetMapping(value = "/resultSchedule/{scheduleId}")
    public ResponseEntity<?> resultSchedule(@PathVariable("scheduleId") long scheduleId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pautaService.resultSchedule(scheduleId));
    }

}
