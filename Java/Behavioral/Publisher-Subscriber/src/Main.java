import publisher.StreamPublisher;

import java.util.concurrent.Flow;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Flow.Publisher<Integer> publisher = new StreamPublisher<>(() -> Stream.of(1, 2, 3, 4));
        publisher.subscribe(new Flow.Subscriber<Integer>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {

            }

            @Override
            public void onNext(Integer item) {
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });
    }
}
