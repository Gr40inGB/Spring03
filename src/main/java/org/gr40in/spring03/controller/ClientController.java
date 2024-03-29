package org.gr40in.spring03.controller;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.entity.Client;
import org.gr40in.spring03.mapper.ClientMapper;
import org.gr40in.spring03.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("client")
public class ClientController {
    private final ClientService service;
    private final ClientMapper mapper;


    @GetMapping()
    public ResponseEntity<List<Client>> getClients(Model model) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllClients());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getClientById(id));
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client Client) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createClient(mapper.toDto(Client)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
