import helpers.Dto;
import helpers.Entity;

import java.util.function.Function;

public class Main {
    private static final Function<Dto,Entity> func1 = dto ->{
        Entity entity = new Entity();
        entity.setId(dto.getId());
        entity.setData(dto.getData());
        return entity;
    };

    private static final Function<Entity,Dto> func2 = entity ->{
        Dto dto = new Dto();
        dto.setId(entity.getId());
        dto.setData(entity.getData());
        return dto;
    };

    public static final Converter<Dto, Entity> converter = new Converter<>(func1, func2);

    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.setId("1");
        entity.setData("Data");

        Dto dto = converter.fromEntity(entity);
        System.out.println(dto.getData());
        System.out.println(dto.getId());

    }
}
