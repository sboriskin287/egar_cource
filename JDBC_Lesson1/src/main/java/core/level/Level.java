package core.level;

import core.hero.*;

import java.util.Map;

public enum Level {
    L1(Map.of(
            Archer.class, new Tuple(1, 1),
            Warrior.class, new Tuple(1, 1),
            Dwarf.class, new Tuple(1, 1),
            Elf.class, new Tuple(1, 1),
            Mage.class, new Tuple(1, 1))),
    L2(Map.of(
            Archer.class, new Tuple(1.2f, 1.3f),
            Warrior.class, new Tuple(1.1f, 1.25f),
            Dwarf.class, new Tuple(1, 1.4f),
            Elf.class, new Tuple(1.3f, 1.05f),
            Mage.class, new Tuple(1.1f, 1.1f))),
    L3(Map.of(Archer.class, new Tuple(1.2f, 1.3f),
            Warrior.class, new Tuple(1.7f, 1.65f),
            Dwarf.class, new Tuple(1, 1.4f),
            Elf.class, new Tuple(1.8f, 1.95f),
            Mage.class, new Tuple(1.1f, 1.1f))),
    L4(Map.of(Archer.class, new Tuple(1.2f, 1.3f),
            Warrior.class, new Tuple(1.1f, 1.25f),
            Dwarf.class, new Tuple(1, 1.4f),
            Elf.class, new Tuple(2.3f, 1.05f),
            Mage.class, new Tuple(1.1f, 2.1f))),
    L5(Map.of(Archer.class, new Tuple(1.2f, 1.3f),
            Warrior.class, new Tuple(1.1f, 1.25f),
            Dwarf.class, new Tuple(2, 1.9f),
            Elf.class, new Tuple(1.3f, 1.05f),
            Mage.class, new Tuple(1.1f, 1.1f)));

    private final Map<Class<? extends Hero>, Tuple> heroMap;

    Level(Map<Class<? extends Hero>, Tuple> heroMap) {
        this.heroMap = heroMap;
    }

    public Tuple getTuple(Hero hero) {
        return heroMap.get(hero.getClass());
    }
}
