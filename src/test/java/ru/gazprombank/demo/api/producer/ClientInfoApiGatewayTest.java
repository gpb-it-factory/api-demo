package ru.gazprombank.demo.api.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClientInfoApiGatewayTest {


    @Test
    void findClientInfo() throws JsonProcessingException {
        //arrange
        var clientInfoApiGateway = new ClientInfoApiGateway();
        //act
        String jsonString = clientInfoApiGateway.findClientInfo("fb8e6e5f-1d9c-4535-a733-21595ec569d7");
        //assert
        assertThat(jsonString).isEqualTo("{\"id\":\"fb8e6e5f-1d9c-4535-a733-21595ec569d7\",\"name\":\"Vadim\",\"sername\":\"Vaganov\"}");
    }

}