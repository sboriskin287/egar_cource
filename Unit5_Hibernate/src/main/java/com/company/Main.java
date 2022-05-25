package com.company;

import com.company.dao.MageDao;
import com.company.dao.WarriorDao;
import com.company.entity.Hero;
import com.company.entity.Mage;
import com.company.entity.Warrior;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        WarriorDao dao = new WarriorDao();
        MageDao mDao = new MageDao();

        List<Mage> l = mDao.findByHealthGreatherThen(110f);
        System.out.println();
    }
}
