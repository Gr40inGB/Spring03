package org.gr40in.spring03.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.config.LibraryProperties;
import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.entity.Client;
import org.gr40in.spring03.entity.Rental;
import org.gr40in.spring03.mapper.BookMapper;
import org.gr40in.spring03.mapper.ClientMapper;
import org.gr40in.spring03.repository.BookRepository;
import org.gr40in.spring03.repository.ClientRepository;
import org.gr40in.spring03.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final LibraryProperties properties;

    private final RentalRepository rentalRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

//    @Value("${application.allowed}")
//    int max;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(long id) {
        var Rental = rentalRepository.findById(id);
//        System.out.println(max);
        if (Rental.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
        return Rental.get();
    }

    @Transactional
    public Rental createRental(Rental rental) {

        System.out.println("aim here" + properties.getAllowed());
        long bookId = rental.getBook().getId();
        long clientId = rental.getClient().getId();


        if (!bookRepository.existsById(bookId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found book " + bookId);
        if (!clientRepository.existsById(clientId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found client " + clientId);

        Client client = clientRepository.findById(clientId).get();
        Book book = bookRepository.findById(bookId).get();

        var countOfBooks = rentalRepository.countAllByClientAndReturnTimeIsNull(client);

        if (countOfBooks >= properties.getAllowed())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client have books more than "
                    + properties.getAllowed() + ". No more rental allowed");

        rentalRepository.save(rental);
        rental.setStartTime(LocalDateTime.now());
        rental.setBook(bookRepository.findById(rental.getBook().getId()).get());
        rental.setClient(clientRepository.findById(rental.getClient().getId()).get());
        return rental;
    }

    @Transactional
    public Rental returnBook(long id) {
        var persistRental = rentalRepository.findById(id);
        if (persistRental.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found rental " + id);
        } else persistRental.get().setReturnTime(LocalDateTime.now());
        return persistRental.get();
    }


    public void deleteById(long id) {
        if (rentalExist(id)) rentalRepository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
    }

    public boolean rentalExist(long id) {
        return rentalRepository.existsById(id);
    }


}
