package com.ajayaraj.lodgesage.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String role;
}
