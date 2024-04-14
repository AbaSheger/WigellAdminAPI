package org.example.wigelladminapi.Repositories;

import org.example.wigelladminapi.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
