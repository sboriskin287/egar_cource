package core.hero;

public class Mage extends Hero {
    private int mana = 100;
    private int manaCost;

    public Mage(int damageFromHealth, int manaCost) {
        super(damageFromHealth);
        this.manaCost = manaCost;
    }

    @Override
    protected void attack() {
        System.out.println("Кастую магией, тебе конец");
    }

    @Override
    public void attack(Hero enemy) {
        if (isManaEmpty()) {
            System.out.println("Нет маны, отрегенься");
            return;
        }
        super.attack(enemy);
        mana -= manaCost;
        System.out.printf("Осталось маны %d%n%n", mana);
    }

    private boolean isManaEmpty() {
        return mana <= 0;
    }
}
