import java.util.Scanner;
import java.util.concurrent.Flow;

public class Main {
    public static void main(String args[])
    {
        String text = "";

        StringPublisher publisher = new StringPublisher();
        Flow.Subscriber number = new NumberSubscriber();
        Flow.Subscriber symbol = new SymbolSubscriber();
        Flow.Subscriber alpha = new AlphabetSubscriber();

        publisher.subscribe(number);
        publisher.subscribe(symbol);
        publisher.subscribe(alpha);

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter String : ");
            text = scanner.nextLine();
            if(!text.equals("E")){
                publisher.publish(text);
            }
        }
    }
}