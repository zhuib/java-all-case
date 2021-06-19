package day01;


import org.junit.Assert;
import org.junit.Test;

/**
 * Author: zhuib
 * Date: 2020/10/5 11:37
 * Describe:
 */
public class TestDemo {

    @Test
    public void test01() {
        System.out.println("112");
        Assert.assertEquals(10,add(5,5));
    }

    public int add(int a, int b) {
        return a+ b;
    }
}
