package file;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
      /*  static String pathSeparator  与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
        static char pathSeparatorChar    与系统有关的路径分隔符。
        static String separator     与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
        static char separatorChar   与系统有关的默认名称分隔符。
        */

        String pathSeparator = File.pathSeparator; // 路径分隔符 ；
        System.out.println(pathSeparator);
        String separator = File.separator;    // 文件分隔符  /
        System.out.println(separator);

        demo01();

    }



    private static void demo01() {
        File file = new File("c.txt");
        System.out.println(file);

    }
}
