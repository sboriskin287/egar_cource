package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum ItemType {
    BOOTS(1), CHESTPLATE(2), HELMET(3);

    public static ItemType getByType(Integer type) {
        return Stream.of(ItemType.values())
                .filter(i -> i.getType().equals(type))
                .findFirst()
                .orElse(null);
    }

    private final Integer type;
}
