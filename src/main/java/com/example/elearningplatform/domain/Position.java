package com.example.elearningplatform.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;

    @ManyToOne
    private User users;

}
