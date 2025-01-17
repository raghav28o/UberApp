package com.project.uber.uberApp.entities;
import com.project.uber.uberApp.entities.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.results.graph.Fetch;

import java.util.Set;


@Entity
@Getter
@Setter
@Data
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @ElementCollection(fetch=FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
