package emptyPoolStrategy;

import instantiable.Instantiable;

import java.util.Set;
import java.util.function.Supplier;

public interface Strategy<T> {
        void invokeStrategy(Set<T> availabe, Supplier<T> supplier);
}
