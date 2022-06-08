package com.company.core;

public class Archer extends Hero {

    public Archer(int damageFromHealth) {
        super(damageFromHealth);
    }

    @Override
    protected void attack() {
        System.out.println("Я лучник, лови стрелу");
    }
}
