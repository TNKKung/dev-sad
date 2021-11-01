public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber() {
        super("Alphabet");
    }

    @Override
    public String match() {
        return ".*[a-zA-Z].*";
    }
}