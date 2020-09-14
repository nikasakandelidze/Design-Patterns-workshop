package emptyPoolStrategy;


import java.util.Set;
import java.util.function.Supplier;

public class CreateNewOneStrategy<T> implements Strategy<T> {


    @Override
    public void invokeStrategy(Set<T> available, Supplier<T> supplier) {
        available.add(supplier.get());
    }
}
