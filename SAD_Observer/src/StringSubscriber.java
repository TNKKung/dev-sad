import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

abstract public class StringSubscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
    private FileWriter writer;
    private String filename;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String text) {
        int lenText = text.length();
        if (lenText != 0) {
            try {
                writer = new FileWriter(filename, true);
                writer.write(text);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            subscription.request(1);
        } else {
            System.out.println("Is Empty!");
        }
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    public StringSubscriber(String name) {
        try {
            filename = name + ".txt";
            File Object = new File(filename);
            if (Object.createNewFile()) {
                System.out.println("Create File: " + Object.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract public String match();
}