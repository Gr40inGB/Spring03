package org.gr40in.spring03.mapper;

import org.gr40in.spring03.dto.ClientDto;
import org.gr40in.spring03.entity.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientMapper {
    public ClientDto toDto(Client Client) {
        return ClientDto.builder()
                .name(Client.getName())
                .contact(Client.getContact())
                .build();
    }

    public Client toEntity(ClientDto ClientDto) {
        return Client.builder()
                .id(ClientDto.getId())
                .name(ClientDto.getName())
                .contact(ClientDto.getContact())
                .build();
    }

    public List<ClientDto> listEntityToListDto(List<Client> list) {
        return list.stream().map(this::toDto).toList();
    }

    public List<Client> listDtoToListEntity(List<ClientDto> list) {
        return list.stream().map(this::toEntity).toList();
    }
}

