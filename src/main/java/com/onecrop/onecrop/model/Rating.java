package com.onecrop.onecrop.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String description;


    //must be 1 to 5 only
    @Column
    private Integer rating;


    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;


    @Column(nullable=false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable=false)
    @LastModifiedDate
    private LocalDateTime updatedAt;






}
