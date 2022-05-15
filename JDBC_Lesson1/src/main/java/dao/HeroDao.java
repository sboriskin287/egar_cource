package dao;

import core.hero.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroDao<T extends Hero> {

    List<? extends Hero> findAllHero();

    Optional<T> findHeroById(Integer id);

    Optional<T> findHeroByName(String name);

    void saveHero(T hero);

    void updateHero(T hero);

    void deleteHero(T hero);

}
