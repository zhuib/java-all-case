package tdd;

/**
 * Date: 2021/3/24 14:44
 */
public class Fibonacci {

/*    public static void main(String[] args) {
        int num = 50;
        long[] contains = new long[50];
        fibonacci(num, contains);
        System.out.println(Arrays.toString(contains));
//        for (int n = 1; n <= num; n++) {
//            contains[n-1] = recursive(n);
//        }
//        System.out.println(Arrays.toString(contains));


    }*/

    public static long fibonacci(int num/*,long[] contains*/) {

        if (num < 1) {
            return -1;
        }
        if (num == 1 || num == 2) {
            return 1;
        }

        long[] arr = new long[num];
        arr[0] = arr[1] = 1;
        for (int n = 2; n < num; n++) {
            arr[n] = arr[n - 1] + arr[n - 2];
            arr[num - 1] = arr[n];
        }

      /*  for (int n = 0; n < arr.length; n++) {
            contains[n] = arr[n];
        }*/
        return arr[num - 1];
    }

    public static long recursive(int n) {

        if (n ==1 || n==2){
            return 1;
        }
        if (n > 2){
            return recursive(n-1) + recursive(n-2);
        }
        return -1;
    }
}
