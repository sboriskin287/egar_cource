package entity;

import lombok.Data;

@Data
public class WarriorEntity {
    private int mana = 100;
    private HeroEntity hero;
}
