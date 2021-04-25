package com.projetoavenue.controlepautas.service;


import com.projetoavenue.controlepautas.builder.AssociatedVoteScheduleBuilder;
import com.projetoavenue.controlepautas.builder.ScheduleBuilder;
import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
import com.projetoavenue.controlepautas.models.OpenSessionInSchedule;
import com.projetoavenue.controlepautas.models.ResultSchedule;
import com.projetoavenue.controlepautas.models.Schedule;
import com.projetoavenue.controlepautas.models.DTO.AssociatedVoteScheduleDTO;
import com.projetoavenue.controlepautas.models.enums.ScheduleType;
import com.projetoavenue.controlepautas.models.enums.UserInfoType;
import com.projetoavenue.controlepautas.repository.AssociatedVoteScheduleRepository;
import com.projetoavenue.controlepautas.repository.PautaRepository;
import com.projetoavenue.controlepautas.service.external.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;
    @Autowired
    private ScheduleBuilder scheduleBuilder;
    @Autowired
    private ExternalService externalService;
    @Autowired
    private AssociatedVoteScheduleBuilder associatedVoteScheduleBuilder;
    @Autowired
    private AssociatedVoteScheduleRepository associatedVoteScheduleRepository;

    public ResponseEntity<?> newSchedule(ScheduleDTO scheduleDTO){
        var pauta = scheduleBuilder.SchedulefromDTOToEntity(scheduleDTO);
        log.info("Cadastrando nova Pauta ", scheduleDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pautaRepository.save(pauta));
    }

    public ResponseEntity<?> votarPauta(AssociatedVoteScheduleDTO associatedVoteScheduleDTO){
        var ableToVote = this.externalService.consumerApiCheckCPF(associatedVoteScheduleDTO.getCpf());
        if(!ableToVote.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            if(ableToVote.getBody().getStatus().equals(UserInfoType.ABLE_TO_VOTE.toString())){
                var pauta = this.associatedVoteScheduleBuilder.AssociatedVoteScheduleDTOfromDTOToEntity(associatedVoteScheduleDTO);
                var schedule = this.pautaRepository.findById(pauta.getScheduleId());
                if(schedule.isPresent()){
                    if(schedule.get().getOpenedSession()){
                       var associated= this.associatedVoteScheduleRepository.findByAssociatedId(associatedVoteScheduleDTO.getAssociatedId());
                        if(associated.isPresent()){
                            return ResponseEntity.status(HttpStatus.CREATED).body("Só é permitido um voto por Pauta.") ;
                        }else{
                            return ResponseEntity.status(HttpStatus.CREATED).body(this.associatedVoteScheduleRepository.save(pauta));
                        }

                    }else{
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("O tempo de votação já foi encerrado.");
                    }
                }else{
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Pauta não encontrada na nossa base");
                }

            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cpf não liberado para votar");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf inválido");
        }
    }

    public void openSessionInShcedule(OpenSessionInSchedule openSessionInSchedule){
        ResponseEntity.status(HttpStatus.CREATED).body(this.pautaRepository.save(Schedule.builder().
                id(openSessionInSchedule.getIdSchedule()).openedSession(true).build()));
        log.info("Iniciando sessão da Pauta: ", openSessionInSchedule.getIdSchedule());
        try{
            new Thread(()-> {
                try{
                    this.closeSession(openSessionInSchedule);
                } catch (Exception e){

                }
            }).start();
        }catch (Exception e){

        }
    }

    public void closeSession(OpenSessionInSchedule openSessionInSchedule) throws InterruptedException {
        new Thread().sleep(openSessionInSchedule.getTimeWithSessionStayOpen() * 1000);
        log.info("Encerrando sessão da Pauta: ", openSessionInSchedule.getIdSchedule());
        this.pautaRepository.save(Schedule.builder().id(openSessionInSchedule.getIdSchedule()).openedSession(false).build());
    }

    public ResultSchedule resultSchedule(long scheduleId){
        var schedules = this.associatedVoteScheduleRepository.findByScheduleId(scheduleId);
        var resultSchedule = new ResultSchedule();
        log.info("Imprimindo resultado da pauta ", scheduleId);
        schedules.get().stream().forEach(s->{
            if (s.getVote().equals(ScheduleType.SIM)) {
                resultSchedule.setVotosSim(resultSchedule.getVotosSim() + 1);
            } else {
                resultSchedule.setVotosNão(resultSchedule.getVotosNão() + 1);
            }
        });
        return resultSchedule;
    }


}
