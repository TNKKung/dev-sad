public class NumberSubscriber extends StringSubscriber {

    public NumberSubscriber() {
        super("Number");
    }

    @Override
    public String match() {
        return ".*[0-9].*";
    }
}