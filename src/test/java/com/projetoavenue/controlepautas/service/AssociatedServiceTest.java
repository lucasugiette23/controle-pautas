package com.projetoavenue.controlepautas.service;

import com.projetoavenue.controlepautas.models.Associated;
import com.projetoavenue.controlepautas.models.DTO.ScheduleDTO;
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
public class AssociatedServiceTest {

    @Autowired
    private AssociatedService associatedService;

    @Test
    public void registerAssociateTest(){
        var test = this.associatedService.registerAssociate(Associated.builder()
        .birthdate("1994-07-23").cpf("86164339022").name("AssociadoTest").build());
        Assert.assertEquals("86164339022", test.getBody().getCpf());
        Assert.assertEquals("AssociadoTest", test.getBody().getName());
    }

}
