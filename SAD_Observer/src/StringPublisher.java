import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String> {
    private Set<StringSubscription> subscribers = new LinkedHashSet<>();
    final ExecutorService executor = Executors.newFixedThreadPool(8);

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        StringSubscription subscription = new StringSubscription(subscriber, executor);
        subscribers.add(subscription);
        subscriber.onSubscribe(subscription);
    }

    public void publish(String text) {
        System.out.println("Publish " + text + " to subscribers.");

        int LengthOfText = text.length();
        for (int item = 0; item < LengthOfText; item++) {
            String s = text.substring(0, 1);
            text = text.substring(1);
            for (StringSubscription subscription: subscribers) {
                String template = ((StringSubscriber) subscription.subscriber).match();
                if (s.matches(template) == true) {
                    subscription.publish(s);
                }
            }
        }
    }
}