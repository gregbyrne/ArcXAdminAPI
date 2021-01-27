package com.app.arcx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "steps_to_help_prepare_items")
public class StepsToHelpPrepareItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentid;
    public Integer aoiId;
    public Integer aoiItemsId;
    public Integer aoiSubItemsId;


    public String name;
    public String content;
    public String subTitle;

}
