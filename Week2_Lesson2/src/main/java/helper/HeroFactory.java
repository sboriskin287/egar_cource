package helper;

import core.hero.*;

public class HeroFactory {
    private HeroFactory() {
        throw new UnsupportedOperationException();
    }

    public static Hero createArcher() {
        return new Archer(10);
    }

    public static Hero createWarrior() {
        return new Warrior(30);
    }

    public static Hero createMage() {
        return new Mage(5, 10);
    }

    public static Hero createElf() {
        return new Elf(0);
    }

    public static Hero createDwarf() {
        return new Dwarf(75);
    }
}
