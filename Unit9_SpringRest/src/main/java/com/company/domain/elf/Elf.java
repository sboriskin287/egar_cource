package com.company.domain.elf;

import com.company.domain.Hero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "elf")
@Data
@EqualsAndHashCode
public class Elf {

    @Id
    @GenericGenerator(
            name = "elf_seq",
            strategy = "sequence",
            parameters = @Parameter(
                    name = "sequence_name",
                    value = "elf_id_seq")
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
