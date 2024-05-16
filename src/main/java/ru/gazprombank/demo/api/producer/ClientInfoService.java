package ru.gazprombank.demo.api.producer;

import java.util.List;
import java.util.UUID;

public class ClientInfoService {

    private final String uuidZero = "fb8e6e5f-1d9c-4535-a733-21595ec569d7";
    private final String uuidOne = "fb8e6e5f-1d9c-4535-a733-21595ec569d8";
    private final List<ClientInfo> clients = List.of(new ClientInfo(
            UUID.fromString(uuidZero),
            "Vadim",
            "Vaganov")
    );

    public ClientInfo findClientInfo(UUID id) {
        for (ClientInfo clientInfo : clients) {
            if (id.equals(clientInfo.getId())) {
                return clientInfo;
            }
        }
        return null;
    }

}
