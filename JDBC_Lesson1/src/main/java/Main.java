import core.hero.Hero;
import core.item.Boots;
import core.item.ChestPlate;
import core.item.Helmet;
import core.level.Level;
import dao.ArcherDao;
import entity.ArcherEntity;
import helper.HeroFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero archer = HeroFactory.createArcher();
        ArcherDao ad = ArcherDao.getInstance();
        List<ArcherEntity> archers = ad.findAllHero();
        archer.attack(archer);
        archer.isDeath();
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

        archer.attack(warrior);
        archer.updateLevel(Level.L2);
        warrior.attack(mage);
        mage.attack(elf);
        mage.updateLevel(Level.L2);
        elf.attack(dwarf);
        elf.updateLevel(Level.L3);
        dwarf.attack(archer);
        dwarf.updateLevel(Level.L4);
    }
}
