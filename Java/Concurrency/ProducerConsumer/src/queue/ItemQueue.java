package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ItemQueue<E> {
    private BlockingQueue<E> blockingQueue;

    public ItemQueue(int size) {
        blockingQueue = new ArrayBlockingQueue<E>(size);
    }

    public void putElement(E element) throws InterruptedException {
        blockingQueue.put(element);
    }

    public E getElement() throws InterruptedException {
        return blockingQueue.take();
    }

}
