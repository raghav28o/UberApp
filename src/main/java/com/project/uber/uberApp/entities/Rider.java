package com.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    // means that 1 rider can associate with only one user
    @JoinColumn(name = "user_id")
    //This specifies the foreign key column (user_id) in the rider table that points to the primary key (id) of the user table.
    //Foreign Key: The user_id column in the rider table will store the primary key of the related User entity. This establishes the relationship between Rider and User in the database.
    private User user;
    private Double rating;
}
