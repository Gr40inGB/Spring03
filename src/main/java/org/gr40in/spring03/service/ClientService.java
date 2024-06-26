package org.gr40in.spring03.service;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.dto.ClientDto;
import org.gr40in.spring03.entity.Client;
import org.gr40in.spring03.entity.Rental;
import org.gr40in.spring03.mapper.ClientMapper;
import org.gr40in.spring03.repository.ClientRepository;
import org.gr40in.spring03.repository.RentalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final RentalRepository rentalRepository;

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public Client getClientById(long id) {
        var Client = repository.findById(id);
        if (Client.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
        return Client.get();
    }

    public List<Rental> findAllRentalByClientId(long id) {
        var client = repository.findById(id);
        if (client.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "client id " + id + " not found");
        return rentalRepository.findAllByClientId(id);
    }


    public Client createClient(ClientDto Client) {
        return repository.save(mapper.toEntity(Client));
    }

    public void deleteById(long id) {
        if (ClientExist(id)) repository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
    }

    public boolean ClientExist(long id) {
        return repository.existsById(id);
    }


}
