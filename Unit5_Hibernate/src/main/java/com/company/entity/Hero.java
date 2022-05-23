package com.company.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hero")
@Data
@EqualsAndHashCode
public class Hero {
    @Id
    /*@GenericGenerator(
            name = "hero_seq",
            strategy = "sequence",
            parameters = @Parameter(
                    name = "sequence_name",
                    value = "hero_id_seq")
    )*/
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Float health;

    @Column(name = "damage")
    private Float damage;
}
