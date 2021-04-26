package com.projetoavenue.controlepautas.service;

import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
import com.projetoavenue.controlepautas.models.ResultSchedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ScheduleServiceTest {

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void newScheduleTest(){
     var test = this.scheduleService.newSchedule(ScheduleDTO.builder().
                cpf("10376906480").createdDate(LocalDateTime.now()).name("Test").build());
     Assert.assertEquals("10376906480", test.getBody().getCpf());
    }

    @Test
    public void resultSchedule(){
        var retorno = this.scheduleService.resultSchedule(2L);
        var resultSchedule = new ResultSchedule();
        resultSchedule.setVotosSim(4L);
        Assert.assertEquals(resultSchedule.getVotosSim(), retorno.getVotosSim());
    }
}
