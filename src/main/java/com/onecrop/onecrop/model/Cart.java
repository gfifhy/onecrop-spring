package com.onecrop.onecrop.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String packageType;

    @Column(nullable = false)
    private Integer quantity;

    /*@CreatedDate
    private Instant createdAt;*/

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
