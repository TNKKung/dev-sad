public class SymbolSubscriber extends StringSubscriber{
    public SymbolSubscriber() {
        super("Symbol");
    }

    @Override
    public String match() {
        return ".*[!-/:-@\\[-`{-~].*";
    }
}