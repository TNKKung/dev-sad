import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {
    private final ExecutorService executor;
    public Flow.Subscriber subscriber;

    @Override
    public void request(long n) {
        if (n < 0)
            return;
    }

    @Override
    public void cancel() {}

    public StringSubscription(Flow.Subscriber subscriber, ExecutorService executor) {
        this.subscriber = subscriber;
        this.executor = executor;
    }

    public void publish(String text) {
        executor.execute(() -> {
            this.subscriber.onNext(text);
        });
    }
}