package com.app.arcx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "regions")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String name;

}
