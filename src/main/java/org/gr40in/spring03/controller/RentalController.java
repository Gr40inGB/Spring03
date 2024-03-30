package org.gr40in.spring03.controller;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.entity.Rental;
import org.gr40in.spring03.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("rental")
public class RentalController {
    private final RentalService service;
//    private final ClientMapper mapper;


    @GetMapping()
    public ResponseEntity<List<Rental>> getRentals(Model model) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllRentals());
    }

    @GetMapping("{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRentalById(id));
    }

    @PostMapping()
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createRental(rental));
    }

    @PutMapping("{id}")
    public ResponseEntity<Rental> returnRentalById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.returnBook(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
