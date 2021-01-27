package com.app.arcx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "steps_to_help_prepare")
public class StepsToHelpPrepare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String name;
    public String subTitle;
    public String description;

}
