package com.onecrop.onecrop.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "wallets")
public class Wallet {

    public Wallet(){
        this.balance = 0.0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private Double balance;

}
