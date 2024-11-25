package com.onecrop.onecrop.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;


    private String name;
    private Double price;
    private Integer quantity;
    private String slug;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    /*@OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;*/

    @Column(nullable=false)
    private LocalDateTime createdAt;

    @Column(nullable=false)
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }


}
