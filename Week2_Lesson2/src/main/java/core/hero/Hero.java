package core.hero;

import core.item.Protectable;
import core.level.Level;
import core.level.Tuple;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    private float health = 100;
    private float damage;
    private final List<Protectable> protects = new ArrayList<>();

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
        System.out.printf("У %s осталось здоровья: %f%n%n",
                enemy.getClass().getSimpleName(), enemy.health);
    }

    public boolean isDeath() {
        return health <= 0;
    }

    private void damage(Hero enemy) {
        int protectSum = enemy.protects
                .stream()
                .peek(i -> System.out.printf("<Применена защита: %s, сохранено здоровья: %d> ",
                        i.getClass().getSimpleName(), i.protect()))
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

    public void updateLevel(Level level) {
        Tuple tuple = level.getTuple(this);
        float newDamage = this.damage * tuple.getDeltaDamage();
        float newHealth = this.health * tuple.getDeltaHealth();
        System.out.printf("<У персонажа %s теперь уровень %d, было %f хп, стало %f хп> ",
                this.getClass().getSimpleName(),
                level.ordinal() + 1,
                health,
                newHealth);
        this.damage = newDamage;
        this.health = newHealth;

    }
}
