import core.hero.Hero;
import core.item.Boots;
import core.item.ChestPlate;
import core.item.Helmet;
import core.level.Level;
import dao.ArcherDao;
import entity.ArcherEntity;
import entity.ItemEntity;
import entity.ItemType;
import helper.HeroFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero archer = HeroFactory.createArcher();
        ArcherDao ad = ArcherDao.getInstance();
        List<ArcherEntity> archers = ad.findAllHero();
        ArcherEntity ae = archers.get(0);
        ae.getHero().setName("new " + ae.getHero().getName());
        ItemEntity ie = new ItemEntity();
        ie.setType(ItemType.HELMET);
        ie.setValue(15);
        ie.setHero(ae.getHero());
        ae.getHero().getItems().add(ie);
        ad.saveHero(ae);
    }
}
