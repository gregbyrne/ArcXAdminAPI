package com.app.arcx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "area_of_interest_sub_items")
public class AreaOfInterestSubItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentid;

    public String name;
    public String value;

}
