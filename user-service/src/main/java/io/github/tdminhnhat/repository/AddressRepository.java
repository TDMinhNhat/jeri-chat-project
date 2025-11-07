package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.Address;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByUser_Id(Long id);
}
