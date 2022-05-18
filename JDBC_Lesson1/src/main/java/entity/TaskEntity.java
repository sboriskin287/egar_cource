package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TaskEntity {
    private Integer id;
    private String name;
    private Integer award;
    private LocationEntity location;
    private List<HeroEntity> heroes = new ArrayList<>();
}
