package entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemEntity {
    private Integer id;
    private String name;
    private Integer value;
    private ItemType type;
    private HeroEntity hero;
}
