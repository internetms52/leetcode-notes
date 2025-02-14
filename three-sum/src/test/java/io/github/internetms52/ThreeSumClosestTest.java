package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumClosestTest {
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    @Test
    public void test1() {
        int result = threeSumClosest.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5},-2);
        System.out.println(result);
    }

    @Test
    public void test2() {
        int result = threeSumClosest.threeSumClosest(new int[]{-4,2,2,3,3,3},0);
        System.out.println(result);
    }
}
