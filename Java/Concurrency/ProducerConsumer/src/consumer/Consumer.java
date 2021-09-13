package consumer;

import queue.ItemQueue;


public class Consumer<E> {
    private final ItemQueue<E> queue;

    private final String consumerId;


    public Consumer(ItemQueue<E> queue, String consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public E consume() throws InterruptedException {
        return queue.getElement();
    }
}
