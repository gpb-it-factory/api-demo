package ru.gazprombank.demo.api.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class ClientInfoApiGateway {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    ClientInfoService clientInfoService = new ClientInfoService();
    String findClientInfo(String id) throws JsonProcessingException {
        var clientInfo = clientInfoService.findClientInfo(UUID.fromString(id));
            return objectMapper.writeValueAsString(clientInfo);
    }

}
