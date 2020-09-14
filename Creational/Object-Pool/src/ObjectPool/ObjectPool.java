package ObjectPool;

import emptyPoolStrategy.CreateNewOneStrategy;
import emptyPoolStrategy.Strategy;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {
    private Set<T> availabe = new HashSet<>();
    private Set<T> inUse = new HashSet<>();
    private Strategy<T> strategy = new CreateNewOneStrategy<>(); //default strategy


    public abstract T createNewInstance();

    public ObjectPool(int initialSize) {
        populatePool(initialSize);
    }

    public synchronized T get() {
        if (availabe.isEmpty()) {
            strategy.invokeStrategy(availabe, this::createNewInstance);
        }
        T instance = availabe.iterator().next();
        availabe.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void putBack(T instance) {
        inUse.remove(instance);
        availabe.add(instance);
    }

    public int getNumberOfAvailableObjects() {
        return availabe.size();
    }

    public int getNumberOfInUseObjects() {
        return inUse.size();
    }

    public void setNewStrategy(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    private void populatePool(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            availabe.add(createNewInstance());
        }
    }
}
