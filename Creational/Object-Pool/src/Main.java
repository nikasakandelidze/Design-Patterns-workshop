import MyConnectionObjectPool.ConnectionsObjectPool;
import MyConnectionObjectPool.CustomConnection;
import ObjectPool.ObjectPool;

public class Main {
    public static void main(String[] args) {
        ObjectPool<CustomConnection> pool = new ConnectionsObjectPool(10);
        CustomConnection customConnection = pool.get();

        //Use it

        pool.putBack(customConnection);
    }
}
