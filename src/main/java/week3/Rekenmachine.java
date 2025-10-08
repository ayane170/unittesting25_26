package week3;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.round;

public class Rekenmachine {
    public Integer add (Integer p1, Integer p2) {
        if (p1 == null || p2 == null){
            throw new IllegalArgumentException("p1 and p2 cannot be null");
        }
        return p1 + p2;
    }
    public Integer subtract (Integer p1, Integer p2) {
        if (p1 == null || p2 == null){
            throw new IllegalArgumentException("p1 and p2 cannot be null");
        }
        return p1 - p2;
    }
    public Integer multiply(Integer p1, Integer p2) {
        if (p1 == null || p2 == null){
            throw new IllegalArgumentException("p1 and p2 cannot be null");
        }
        return p1 * p2;
    }
    public Integer divide(Integer p1, Integer p2) {
        if (p2 == 0){
            throw new IllegalArgumentException("p2 cannot be zero");
        }
        if (p1 == null || p2 == null){
            throw new IllegalArgumentException("p1 and p2 cannot be null");
        }

        BigDecimal a = new BigDecimal(p1);
        BigDecimal b = new BigDecimal(p2);
        BigDecimal q = a.divide(b,20, RoundingMode.HALF_DOWN);
        BigDecimal r = q.setScale(0, RoundingMode.HALF_DOWN);
        return r.intValue();

    }
}
