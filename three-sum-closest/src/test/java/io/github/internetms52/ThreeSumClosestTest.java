package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSumClosestTest {
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    @Test
    public void test1() {
        int result = threeSumClosest.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5},-2);
        Assertions.assertEquals(result,-2);
    }

    @Test
    public void test2() {
        int result = threeSumClosest.threeSumClosest(new int[]{-4,2,2,3,3,3},0);
        Assertions.assertEquals(result,0);
    }

    @Test
    public void test3() {
        int result = threeSumClosest.threeSumClosest(new int[]{-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1},-14);
        Assertions.assertEquals(result,-15);
    }
}
