package entity;

import lombok.Data;

@Data
public class LocationEntity {
    private Integer id;
    private Float xCord;
    private Float yCord;
    private String name;
    private Integer type;
}
