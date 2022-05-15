package core.hero;

public class Elf extends Hero {

    public Elf(int damageFromHealth) {
        super(damageFromHealth);
    }

    @Override
    protected void attack() {
        System.out.println("Я эльф..., общаюсь с животными");
    }
}
