package core.level;

public class Tuple {
    private final float deltaHealth;
    private final float deltaDamage;

    public Tuple(float deltaHealth, float deltaDamage) {
        this.deltaHealth = deltaHealth;
        this.deltaDamage = deltaDamage;
    }

    public float getDeltaHealth() {
        return deltaHealth;
    }

    public float getDeltaDamage() {
        return deltaDamage;
    }
}
