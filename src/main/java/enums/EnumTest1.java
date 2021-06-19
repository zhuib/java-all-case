package enums;

import jdk.nashorn.internal.ir.CallNode;

public class EnumTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
//        获取当前类的父类
        System.out.println(Season1.class.getSuperclass());
//        遍历所有对象
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            value.show();
            System.out.println(value);

        }
//        返回枚举类中对象名
        Season1 spring1 = Season1.valueOf("SPRING");
//        如果没有枚举类对象，则报异常： IllegalArgumentException
//        Season1 spring2 = Season1.valueOf("SPRING1");
        System.out.println(spring1);

        spring1.show();
    }
}

interface Info{
    void show();
}

enum  Season1 implements Info{
    // /1.提供当前枚举类的对象，多个对象之间用”，“隔开，末尾对象”；”结束. 没有 属性则直接写 对象名 ,如 SPRING
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天不回来");
        }
    },
    SUMMER("夏天","夏日炎凉"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋高");
        }
    },
    WINTER("冬天","寒风凛冽"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

//    常量
    private final String seasonName;
    private final String seasonDesc;

//    2.私有化类的构造器，并给对象赋值
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

//    获取属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

/*    @Override
    public void show() {
        System.out.println("这是季节");
    }*/

/*    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/
}
