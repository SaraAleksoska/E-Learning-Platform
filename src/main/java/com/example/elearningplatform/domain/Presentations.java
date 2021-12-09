package com.example.elearningplatform.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Presentations extends Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;


}
