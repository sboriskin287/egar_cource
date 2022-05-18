package entity;

import lombok.Data;

@Data
public class MageEntity {
    private Integer id;
    private HeroEntity hero;
    private int mana = 100;
}
