package tdd;

import junit.framework.TestCase;

/**
 * Date: 2021/3/24 14:11
 */
public class CouponManagerImplTest extends TestCase {

    public void testGetNumOfCoupsCanUse() {
        CouponManagerImpl cm = new CouponManagerImpl();

        assertEquals(0,cm.getNumOfCoupsCanUse(1,0));
        assertEquals(1,cm.getNumOfCoupsCanUse(1,1));
        assertEquals(1,cm.getNumOfCoupsCanUse(1,5));
        assertEquals(2,cm.getNumOfCoupsCanUse(2,5));
        assertEquals(3,cm.getNumOfCoupsCanUse(3,5));
        assertEquals(1,cm.getNumOfCoupsCanUse(3,1));
        //
        assertEquals(1,cm.getNumOfCoupsCanUse(6,1));
        assertEquals(3,cm.getNumOfCoupsCanUse(6,5));

        // 边界检查
        assertEquals(0,cm.getNumOfCoupsCanUse(0,5));
        assertEquals(0,cm.getNumOfCoupsCanUse(4,5));
        assertEquals(0,cm.getNumOfCoupsCanUse(7,5));
//        assertEquals(3,cm.getNumOfCoupsCanUse(4,5));

//        assertEquals(1,Fibonacci.recursive(0));
        assertEquals(1,Fibonacci.recursive(1));
//        assertEquals(12586269025L,Fibonacci.recursive(50));
        assertEquals(12586269025L,Fibonacci.fibonacci(50));
//        assertEquals(12586269025L,Fibonacci.fibonacci(51));
    }
}
