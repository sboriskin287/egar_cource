package com.company;

import com.company.dao.MageDao;
import com.company.dao.WarriorDao;
import com.company.entity.Audit;
import com.company.entity.Hero;
import com.company.entity.Mage;
import com.company.entity.Warrior;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WarriorDao dao = new WarriorDao();
        MageDao mDao = new MageDao();

        List<Mage> m = mDao.findByNameAndHealthAndDamage();
        System.out.println(m);
    }
}
