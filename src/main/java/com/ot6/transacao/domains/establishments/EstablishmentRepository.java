package com.ot6.transacao.domains.establishments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstablishmentRepository extends CrudRepository<Establishment, Long> {

    Optional<Establishment> findByNameAndCityAndAddress(String name, String city, String address);
}
