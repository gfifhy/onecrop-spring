package com.onecrop.onecrop.repository;


import com.onecrop.onecrop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
