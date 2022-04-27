package core.hero;

import core.item.Helmet;
import core.item.Protectable;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    private int health = 100;
    private int damage;
    private List<Protectable> protects = new ArrayList<>();

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
        damage(enemy);
        System.out.printf("У %s осталось здоровья: %d%n%n",
                enemy.getClass().getSimpleName(), enemy.health);
    }

    private boolean isDeath() {
        return health <= 0;
    }

    private void damage(Hero enemy) {
        int protectSum = enemy.protects
                .stream()
                .mapToInt(Protectable::protect)
                .sum();
        if (protectSum > damage) {
            return;
        }
        enemy.health -= (damage - protectSum);
        enemy.correctHealth();
    }

    private void correctHealth() {
        if (health < 0) {
            health = 0;
        }
        if (health > 100) {
            health = 100;
        }
    }

    public List<Protectable> getProtects() {
        return protects;
    }
}
