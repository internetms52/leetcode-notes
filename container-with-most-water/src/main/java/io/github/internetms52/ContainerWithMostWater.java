package io.github.internetms52;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int maxW = height.length - 1;
        for (int i = 0; i < height.length - 1; i++) {
            if (result != 0) {
                if (height[i] == 0) {
                    continue;
                }
                if (height[i] != 0 && result / height[i] > maxW) {
                    continue;
                }
            }
            for (int j = 1; j < height.length; j++) {
                if (result > 0 && height[j] == 0) {
                    continue;
                }
                if (i + j < height.length) {
                    int from = height[i];
                    int to = height[i + j];
                    int tmpResult = min(from, to) * j;
                    if (tmpResult > result) {
                        result = tmpResult;
                    }
                }
            }
        }
        return result;
    }

    public int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
