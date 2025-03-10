package io.github.internetms52;

public class TestData {

    public static int[] case1Given() {
        return new int[]{3, 2, 2, 3};
    }

    public static int[] case1Ans() {
        return new int[]{2, 2};
    }

    public static int[] case2Given() {
        return new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    }

    public static int[] case2Ans() {
        return new int[]{0, 1, 3, 0, 4};
    }
}
