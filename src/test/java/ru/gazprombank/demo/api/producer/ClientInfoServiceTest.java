package ru.gazprombank.demo.api.producer;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class ClientInfoServiceTest {

    @Test void findClientInfo() {
        //arrange
        var clientInfoService = new ClientInfoService();
        //act
        var clientInfo = clientInfoService.findClientInfo(UUID.fromString("fb8e6e5f-1d9c-4535-a733-21595ec569d7"));
        //assert
        assertThat(clientInfo.getName()).isEqualTo("Vadim");
    }

}