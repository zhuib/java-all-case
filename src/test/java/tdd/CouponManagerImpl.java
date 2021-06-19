package tdd;

/**
 * Date: 2021/3/24 14:11
 */
public class CouponManagerImpl {

    public int getNumOfCoupsCanUse(int months, int totalCoups) {
        if (months >= 1 && months <= 3) {
        return (totalCoups >= months) ? months : totalCoups;
    }else if (months == 6) {
        return (totalCoups >= 3) ? 3 : totalCoups;
    }else {
        return 0;
    }
    }
}
/*
        if (months == 1){
            return totalCoups >=1 ? 1 : 0;
        }else if (months == 2){
            return totalCoups >= 2 ? 2 : totalCoups;
        }else if (months >= 3){
            return totalCoups >=3 ? 3 : totalCoups;
        }else {
            return 0;
        }*/


 /*       if (months < 1 || months > 3) {
            return 0;
        }
        return (totalCoups >= months) ? months : totalCoups;
*/


