package com.company.domain.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mage")
@Data
public class Mage {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mage_seq")
    @SequenceGenerator(
            name = "mage_seq",
            sequenceName = "mage_id_seq",
            allocationSize = 1)
    private Integer id;

    private Integer mana;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
