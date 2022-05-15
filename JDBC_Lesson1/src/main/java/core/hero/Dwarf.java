package core.hero;

public class Dwarf extends Hero {

    public Dwarf(int damageFromHealth) {
        super(damageFromHealth);
    }

    @Override
    protected void attack() {
        System.out.println("Лови секирой");
    }
}
