package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ContainerWithMostWaterTest {
    private static final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    void assertTemplate(int[] arr, int answer) {
        Assertions.assertEquals(containerWithMostWater.maxArea(arr), answer);
    }

    int[] readTestIntArr(String path) {
        int[] testData;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        testData = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split(",")))  // 用逗號分割
                    .map(String::trim)  // 去除空白
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (Exception e) {
            throw new RuntimeException("無法讀取測試資料", e);
        }
        return testData;
    }

    @Test
    void case1() {
        assertTemplate(new int[] {
                1, 8, 6, 2, 5, 4, 8, 3, 7
        }, 49);
    }

    @Test
    void case2() {
        assertTemplate(new int[] {
                1, 1
        }, 1);
    }

    @Test
    void case3() {
        assertTemplate(readTestIntArr("src/test/resources/case3.csv"), 705634720);
    }

    @Test
    void case4() {
        assertTemplate(readTestIntArr("src/test/resources/case4.csv"), 999990000);
    }

}
