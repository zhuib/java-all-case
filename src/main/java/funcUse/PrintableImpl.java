package funcUse;

public class PrintableImpl implements Printable {
    @Override
    public void print(String s) {
        new MethodRefObject().printUpperCaseString(s);
    }
}
