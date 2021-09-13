import consumer.Consumer;
import producer.Producer;
import queue.Item;
import queue.ItemQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    /*
        Nothing meaningful, simple example.
        Just wanted to demonstrate how Consumers and producers cooperate via common middle player in different threads.
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 2);

        ItemQueue<Item> queue = new ItemQueue<>(10);

        createProducers(executorService, queue);

        createConsumers(executorService, queue);

    }

    private static void createConsumers(ExecutorService executorService, ItemQueue<Item> queue) {
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                tryToConsume(queue);
            });
        }
    }

    private static void createProducers(ExecutorService executorService, ItemQueue<Item> queue) {
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                tryToProduce(queue);
            });
        }
    }

    private static void tryToConsume(ItemQueue<Item> queue) {
        try {
            consumerProcess(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void tryToProduce(ItemQueue<Item> queue) {
        try {
            producerProcess(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void consumerProcess(ItemQueue<Item> queue) throws InterruptedException {
        int consumerId = 0;
        while (consumerId < 4) {
            Consumer<Item> consumer = new Consumer<>(queue, (consumerId++) + "");
            Item consume = consumer.consume();
            System.out.println(
                    "consumed item: " + consume.toString() + ", Consumer: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

    private static void producerProcess(ItemQueue<Item> queue) throws InterruptedException {
        int producerId = 0;
        while (producerId < 10) {
            Producer<Item> itemProducer = new Producer<>(queue, (producerId++) + "");
            Item element = new Item("nth", "Something");
            itemProducer.produce(element);
            System.out.println(
                    "Produced item: " + element.toString() + ", Producer: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
