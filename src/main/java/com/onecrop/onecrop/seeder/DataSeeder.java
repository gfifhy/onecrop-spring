package com.onecrop.onecrop.seeder;

import com.onecrop.onecrop.exception.EntityDoesntExistException;
import com.onecrop.onecrop.model.Address;
import com.onecrop.onecrop.model.Role;
import com.onecrop.onecrop.model.User;
import com.onecrop.onecrop.model.Wallet;
import com.onecrop.onecrop.repository.AddressRepository;
import com.onecrop.onecrop.repository.RoleRepository;
import com.onecrop.onecrop.repository.UserRepository;
import com.onecrop.onecrop.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;


@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final WalletRepository walletRepository;
    private final AddressRepository addressRepository;

    @Override
    public void run(String... args){
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("ROLE_ADMIN"));
            roleRepository.save(new Role("ROLE_SELLER"));
            roleRepository.save(new Role("ROLE_BUYER"));
        }

        if (userRepository.count() == 0) {
            Wallet adminWallet = new Wallet();
            Wallet buyerWallet = new Wallet();
            Wallet sellerWallet = new Wallet();

            Address adminAddress = new Address(
                    null,
                    "123 Aguho St.",
                    null,
                    "Signal Village",
                    "Taguig City",
                    "National Capital Region",
                    "1639",
                    Instant.now(),
                    Instant.now());

            Address sellerAddress = new Address(
                    null,
                    "123 Aguho St.",
                    null,
                    "Signal Village",
                    "Binan City",
                    "National Capital Region",
                    "1639" ,
                    Instant.now(),
                    Instant.now());

            Address buyerAddress = new Address(
                    null,
                    "123 Aguho St.",
                    null,
                    "Signal Village",
                    "Laoag City",
                    "National Capital Region",
                    "1639",
                    Instant.now(),
                    Instant.now());


            Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseThrow(() ->
                    new EntityDoesntExistException("Role not found"));
            Role sellerRole = roleRepository.findByName("ROLE_SELLER").orElseThrow(() ->
                    new EntityDoesntExistException("Role not found"));
            Role buyerRole = roleRepository.findByName("ROLE_BUYER").orElseThrow(() ->
                    new EntityDoesntExistException("Role not found"));
            User admin = new User(
                    null,
                    "admin",
                    passwordEncoder.encode("Password@123!"),
                    "admin@onecrop.com",
                    "admin",
                    "admin",
                    null,
                    "09123456789",
                    LocalDateTime.now(),
                    null,
                    null,
                    LocalDateTime.now(),
                    adminWallet,
                    adminAddress,
                    adminRole
                    );

            User seller = new User(
                    null,
                    "seller",
                    passwordEncoder.encode("Password@123!"),
                    "seller@onecrop.com",
                    "seller",
                    "seller",
                    null,
                    "09123456780",
                    LocalDateTime.now(),
                    null,
                    null,
                    LocalDateTime.now(),
                    sellerWallet,
                    sellerAddress,
                    sellerRole);

            User buyer = new User(
                    null,
                    "buyer",
                    passwordEncoder.encode("Password@123!"),
                    "buyer@onecrop.com",
                    "buyer",
                    "buyer",
                    null,
                    "09123456781",
                    LocalDateTime.now(),
                    null,
                    null,
                    LocalDateTime.now(),
                    buyerWallet,
                    buyerAddress,
                    buyerRole);



            addressRepository.save(adminAddress);
            addressRepository.save(sellerAddress);
            addressRepository.save(buyerAddress);

            walletRepository.save(adminWallet);
            walletRepository.save(buyerWallet);
            walletRepository.save(sellerWallet);

            userRepository.save(admin);
            userRepository.save(buyer);
            userRepository.save(seller);


        }

    }
}
