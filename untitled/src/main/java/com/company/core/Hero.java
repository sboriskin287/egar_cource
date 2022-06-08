package com.company.core;

public abstract class Hero {
    private float health = 100;
    private float damage;

    public Hero(int damage) {
        this.damage = damage;
    }

    protected abstract void attack();

    public void attack(Hero enemy) {
        if (isDeath()) {
            System.out.println("Враг повержен, отдыхай");
            return;
        }
        System.out.printf("<%s атакует %s> ",
                this.getClass().getSimpleName(),
                enemy.getClass().getSimpleName());
        attack();
        System.out.printf("У %s осталось здоровья: %f%n%n",
                enemy.getClass().getSimpleName(), enemy.health);
    }

    public boolean isDeath() {
        return health <= 0;
    }

    private void correctHealth() {
        if (health < 0) {
            health = 0;
        }
        if (health > 100) {
            health = 100;
        }
    }
}
