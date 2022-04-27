import core.hero.Hero;
import core.item.Boots;
import core.item.ChestPlate;
import core.item.Helmet;
import helper.HeroFactory;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hero archer = HeroFactory.createArcher();
        if (Math.random() > 0.5)
            archer.getProtects().add(new Helmet());
        Hero warrior = HeroFactory.createWarrior();
        if (Math.random() > 0.5)
            warrior.getProtects().add(new ChestPlate());
        Hero mage = HeroFactory.createMage();
        if (Math.random() > 0.5)
            mage.getProtects().add(new ChestPlate());
        Hero elf = HeroFactory.createElf();
        if (Math.random() > 0.5)
            elf.getProtects().add(new Boots());
        Hero dwarf = HeroFactory.createDwarf();

        archer.attack(warrior);
        warrior.attack(mage);
        mage.attack(elf);
        elf.attack(dwarf);
        dwarf.attack(archer);
    }
}
