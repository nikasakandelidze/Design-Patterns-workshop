package publisher;

import java.util.Iterator;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamPublisher<T> implements Flow.Publisher<T> {
    private final Supplier<Stream<T>> streamSupplier;


    public StreamPublisher(Supplier<Stream<T>> streamSupplier) {
        this.streamSupplier = streamSupplier;
    }

    /**
     * Publisher subscribe must call onSubscribe on the provided subscriber
     * prior to any other signals to that subscriber. this method must return normally
     * except of when subscriber passed is null it should throw null pointer exception
     */
    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new StreamSubscription(subscriber));
    }

    private class StreamSubscription implements Flow.Subscription {
        private final Flow.Subscriber<? super T> subscriber;
        private final Iterator<? extends T> iterator;
        /**
         * It's written in manifesto that publisher-subscriber pattern should support
         * termination flag, so we use it here as an atomic boolean.
         */
        private final AtomicBoolean isTerminated = new AtomicBoolean(false);

        private StreamSubscription(Flow.Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
            this.iterator = streamSupplier.get().iterator();
        }

        /**
         * request(n) method is used to provide transparent backpressure control.
         * it is used from subscriber to notify publisher about it's demands.
         * It's cool beacuse it introduces pull model(currently it's only push model),
         * since publisher can push items to subscriber.
         *
         * @param n
         */
        @Override
        public void request(long n) {

            for (long l = n; l > 0 && iterator.hasNext() && !isTerminated(); l--) {
                subscriber.onNext(iterator.next());
            }

            if (!iterator.hasNext() && !isTerminated()) {
                subscriber.onComplete();
            }
        }

        @Override
        public void cancel() {
            terminate();
        }

        public boolean isTerminated() {
            return isTerminated.get();
        }

        public void terminate() {
            isTerminated.getAndSet(true);
        }
    }
}
