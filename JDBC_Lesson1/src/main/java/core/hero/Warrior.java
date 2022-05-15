package core.hero;

public class Warrior extends Hero {

    public Warrior(int damageFromHealth) {
        super(damageFromHealth);
    }

    @Override
    protected void attack() {
        System.out.println("Бью мечом");
    }
}
