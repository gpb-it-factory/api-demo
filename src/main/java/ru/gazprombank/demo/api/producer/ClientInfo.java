
package ru.gazprombank.demo.api.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ClientInfo {

    @NonNull private final UUID id;
    @NonNull private final String name;
    @NonNull private final String sername;

}
