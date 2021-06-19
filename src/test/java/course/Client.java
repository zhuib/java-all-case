package course;

/**
 * Date: 2021/4/11 23:34
 */
public class Client {
    public static void main(String[] args){
        Literary literary;
        XiaoMing xiaoMing;
        literary = new LiteraryClassic();
        xiaoMing =new XiaoMing();
        //小明阅读文学经典
        xiaoMing.read(literary);
    }
}
interface Literary{
    public void read();
}
//文学经典类
class LiteraryClassic implements Literary{
    //阅读文学经典
    public void read(){
        System.out.println("文学经典阅读，滋润自己的内心心灵");
    }
}
//小明类
class XiaoMing{
    public void read(Literary literary) {
        literary.read();
    }
}

