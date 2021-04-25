package com.projetoavenue.controlepautas.service.external;

import com.projetoavenue.controlepautas.config.UserInfoConfig;
import com.projetoavenue.controlepautas.models.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@Slf4j
@Service
public class ExternalService {


    @Autowired
    private UserInfoConfig userInfoConfig;
    public ResponseEntity<ExternalResponse> consumerApiCheckCPF(String cpf){
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("user-info.herokuapp.com/users").setPath(cpf);
        log.info("Iniciando requisição a API da user-info para consulta do CPF:", cpf);
        URI uri = URI.create(builder.toString());
        return new RestTemplate().getForEntity(uri, ExternalResponse.class);
    }


}
