package com.company;

import com.company.dao.WarriorDao;
import com.company.entity.Hero;
import com.company.entity.Warrior;

public class Main {

    public static void main(String[] args) {
        WarriorDao dao = new WarriorDao();
        /*Warrior w = dao.findById(1);
        w.getHero().setName("new " + w.getHero().getName());*/

        Warrior wn = new Warrior();
        Hero hn = new Hero();
        hn.setName("new Hero in unit 5");
        hn.setHealth(100f);
        hn.setDamage(100f);
        dao.save(wn);
        System.out.println(wn);
    }
}
