package com.pavlova.pavlova.modules.user.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
public class Client {

    @Id
    @SequenceGenerator(name="client_seq", sequenceName = "client_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="client_seq")
    private Long id;
    private String email;
    private String password;
    private boolean status;

    public Client() {
    }

}
