package com.onecrop.onecrop.repository;

import com.onecrop.onecrop.model.Address;
import com.onecrop.onecrop.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    Optional<Address> findById(UUID id);
}
