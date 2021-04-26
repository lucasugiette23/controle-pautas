package com.projetoavenue.controlepautas.controller;


import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
import com.projetoavenue.controlepautas.models.DTO.AssociatedVoteScheduleDTO;
import com.projetoavenue.controlepautas.models.OpenSessionInSchedule;
import com.projetoavenue.controlepautas.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping(value = "/newSchedule")
    public ResponseEntity<?> newSchedule(@RequestBody ScheduleDTO scheduleDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(scheduleService.newSchedule(scheduleDTO));
    }

    @PostMapping(value = "/votarPauta")
    public ResponseEntity<?> votarPauta(@RequestBody AssociatedVoteScheduleDTO associatedVoteScheduleDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(scheduleService.votarPauta(associatedVoteScheduleDTO));
    }

    @PostMapping(value = "/openSessionInSchedule")
    public void openSessionInSchedule(@RequestBody OpenSessionInSchedule openSessionInSchedule){
       scheduleService.openSessionInShcedule(openSessionInSchedule);
    }
    @GetMapping(value = "/resultSchedule/{scheduleId}")
    public ResponseEntity<?> resultSchedule(@PathVariable("scheduleId") long scheduleId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(scheduleService.resultSchedule(scheduleId));
    }

}
