package com.company.repo;

import com.company.core.entity.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HeroRepo extends CustomRepo<Hero, Integer> {

    Optional<Hero> findByName(String name);

    /*@Query("SELECT h FROM Hero h " +
            "WHERE h.name LIKE :pattern " +
            "AND h.audit.updateAt IS NULL " +
            "AND h.damage BETWEEN :low AND :high")
    List<Hero> findWithComplexQuery(@Param("pattern") String pattern,
                                    @Param("low") Float low,
                                    @Param("high") Float high);*/

}
