package org.gr40in.spring03.repository;

import org.gr40in.spring03.entity.Client;
import org.gr40in.spring03.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
