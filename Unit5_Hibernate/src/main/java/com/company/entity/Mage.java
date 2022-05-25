package com.company.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mage")
@Data
@NamedQuery(
        name = "exists_tasks_query",
        query = "SELECT m FROM Mage m " +
                "WHERE m.hero.tasks IS NOT EMPTY"
)
@NamedQuery(
        name = "health_more",
        query = "SELECT m FROM Mage m " +
                "WHERE m.hero.health > :health"
)
public class Mage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
