package org.gr40in.spring03.service;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.entity.Rental;
import org.gr40in.spring03.mapper.BookMapper;
import org.gr40in.spring03.mapper.ClientMapper;
import org.gr40in.spring03.repository.BookRepository;
import org.gr40in.spring03.repository.ClientRepository;
import org.gr40in.spring03.repository.RentalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(long id) {
        var Rental = rentalRepository.findById(id);
        if (Rental.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
        return Rental.get();
    }

    public Rental createRental(Rental rental) {

        if (bookRepository.existsById(rental.getBook().getId())
                && clientRepository.existsById(rental.getClient().getId()))
            return rentalRepository.save(rental);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "something wrong");

    }

    public void deleteById(long id) {
        if (rentalExist(id)) rentalRepository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
    }

    public boolean rentalExist(long id) {
        return rentalRepository.existsById(id);
    }


}
