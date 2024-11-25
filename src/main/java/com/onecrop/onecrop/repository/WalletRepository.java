package com.onecrop.onecrop.repository;

import com.onecrop.onecrop.model.Role;
import com.onecrop.onecrop.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    Optional<Wallet> findById(UUID id);
}
