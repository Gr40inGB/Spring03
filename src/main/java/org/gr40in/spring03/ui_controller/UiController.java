package org.gr40in.spring03.ui_controller;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.service.BookService;
import org.gr40in.spring03.service.ClientService;
import org.gr40in.spring03.service.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller()
@RequestMapping("ui")
public class UiController {
    private final BookService bookService;
    private final ClientService clientService;
    private final RentalService rentalService;

    @RequestMapping("book")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping("client")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @RequestMapping("rental")
    public String getAllRentals(Model model) {
        model.addAttribute("rentals", rentalService.getAllRentals());
        return "rentals";
    }

    @RequestMapping("client/{id}")
    public String getClientAndHisRentalByClientID(@PathVariable long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        model.addAttribute("rentals", clientService.findAllRentalByClientId(id));
        return "clientsRental";
    }

}
