package org.gr40in.spring03.repository;

import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
