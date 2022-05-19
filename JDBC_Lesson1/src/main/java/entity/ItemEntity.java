package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemEntity {
    private Integer id;
    private Integer value;
    private ItemType type;
    private HeroEntity hero;
}
