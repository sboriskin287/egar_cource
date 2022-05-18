package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HeroEntity {
    private int id;
    private String name;
    private float health = 100;
    private float damage;
    private List<ItemEntity> items = new ArrayList<>();
    private List<TaskEntity> tasks = new ArrayList<>();
}
