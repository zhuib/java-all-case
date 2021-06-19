package extend;

public class Fu {

    private int n;
    Fu() {
        System.out.println("Fu()");
    }
}

class Zi extends Fu {
    Zi () {
        System.out.println("Zi()");
    }

    public static void main(String[] args) {
        Zi zi = new Zi();
    }
}
