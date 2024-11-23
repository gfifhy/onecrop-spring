package com.onecrop.onecrop.seeder;

import com.onecrop.onecrop.exception.EntityDoesntExistException;
import com.onecrop.onecrop.model.Role;
import com.onecrop.onecrop.model.User;
import com.onecrop.onecrop.repository.RoleRepository;
import com.onecrop.onecrop.repository.UserRepository;
import com.onecrop.onecrop.exception.EntityDoesntExistException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args){
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("ROLE_ADMIN"));
            roleRepository.save(new Role("ROLE_SELLER"));
            roleRepository.save(new Role("ROLE_BUYER"));
        }

        if (userRepository.count() == 0) {
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
                    adminRole);

            User seller = new User(
                    null,
                    "seller",
                    passwordEncoder.encode("Password@123!"),
                    "seller@onecrop.com",
                    "seller",
                    "seller",
                    sellerRole);

            User buyer = new User(
                    null,
                    "buyer",
                    passwordEncoder.encode("Password@123!"),
                    "buyer@onecrop.com",
                    "buyer",
                    "buyer",
                    buyerRole);

            userRepository.save(admin);
            userRepository.save(buyer);
            userRepository.save(seller);

        }

    }
}
