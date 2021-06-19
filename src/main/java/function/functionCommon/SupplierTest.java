package function.functionCommon;

import java.util.function.Supplier;

public class SupplierTest {
    public static int getString(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int maxx = getString(() -> {
            int[] arr = {100, 55, -5, 8, 450, 300, 0};
            int max = arr[0];
            for (int i : arr) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxx);
    }
}
