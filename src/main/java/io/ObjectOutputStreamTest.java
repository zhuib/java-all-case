package io;

import java.io.*;
import java.util.Date;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws Exception {
//        oos();
           ois();
    }

    private static void ois() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.txt"));

        Object o = ois.readObject();
        Person p = (Person)o;
        ois.close();
        System.out.println(p);
        System.out.println(p.getName()+""+p.getBirthday());
    }

    private static void oos() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.txt"));
        Person p = new Person();
        p.setName("zhangsan");
        p.setGender("男");
        p.setAge(12);
        p.setBirthday(new Date());

        oos.writeObject(p);
    }
    }
