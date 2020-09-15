package producer;


import queue.ItemQueue;

public class Producer<E> {
    private final ItemQueue<E> queue;

    private final String consumerId;


    public Producer(ItemQueue<E> queue, String consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void produce(E element) throws InterruptedException {
        queue.putElement(element);
    }
}
