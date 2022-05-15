package core.hero;

public class Archer extends Hero {

    public Archer() {
    }

    public Archer(int damageFromHealth) {
        super(damageFromHealth);
    }

    @Override
    protected void attack() {
        System.out.println("Я лучник, лови стрелу");
    }
}
