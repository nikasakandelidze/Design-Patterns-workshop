package MyConnectionObjectPool;


import ObjectPool.ObjectPool;


public class ConnectionsObjectPool extends ObjectPool<CustomConnection> {


    public ConnectionsObjectPool(int initialSize) {
        super(initialSize);
    }

    @Override
    public CustomConnection createNewInstance() {
        return new CustomConnection();
    }
}
