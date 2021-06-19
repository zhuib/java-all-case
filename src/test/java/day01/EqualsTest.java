package day01;

public class EqualsTest {
        private String name = "abc";
        public static void main(String[] args) {
            EqualsTest test = new EqualsTest();
            EqualsTest testB = new EqualsTest();
            System.out.println(test);
            System.out.println(testB);
            String result = test.equals(testB) + ",";
            result += test.name.equals(testB.name) + ",";
            System.out.println(test.name);
            System.out.println(testB.name);
            result += test.name == testB.name;
            result += test == testB;
            System.out.println(result);
        }
    }
