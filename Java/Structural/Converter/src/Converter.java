import java.util.function.Function;

public class Converter<I,O> {
    private final Function<I,O> fromDto;
    private final Function<O,I> fromEntity;

    public Converter(Function<I, O> fromDto, Function<O, I> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public O fromDto(I input){
        return fromDto.apply(input);
    }

    public I fromEntity(O input){
        return fromEntity.apply(input);
    }
}
