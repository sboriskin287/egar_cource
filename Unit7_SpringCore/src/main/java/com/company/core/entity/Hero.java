package com.company.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "hero")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"tasks", "items"})
public class Hero {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hero_seq")
    @SequenceGenerator(
            name = "hero_seq",
            sequenceName = "hero_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Float health;

    @Column(name = "damage")
    private Float damage;

    @Column(name = "cash")
    private BigDecimal cash;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hero")
    private List<Item> items;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "hero_task",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    @Embedded
    private Audit audit = new Audit();
}
