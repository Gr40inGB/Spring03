package org.gr40in.spring03.repository;

import org.gr40in.spring03.entity.Client;
import org.gr40in.spring03.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

//    public int findAllByClientAndAndReturnTimeIsNull();

    public int countAllByClientAndReturnTimeIsNull(Client client);

    public List<Rental> findAllByClientId(long id);

}
