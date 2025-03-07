package io.github.internetms52;

public class TestData {

    public static int[] case1Given() {
        return new int[]{1, 1, 2};
    }

    public static int[] case1Ans() {
        return new int[]{1, 2};
    }

    public static int[] case2Given() {
        return new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    }

    public static int[] case2Ans() {
        return new int[]{0, 1, 2, 3, 4};
    }
}
