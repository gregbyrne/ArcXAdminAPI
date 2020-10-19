package com.app.arcx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "area_of_interest")
public class AreaOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String name;

}
