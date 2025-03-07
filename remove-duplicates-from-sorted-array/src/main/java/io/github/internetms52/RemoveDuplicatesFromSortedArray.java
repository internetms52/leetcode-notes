package io.github.internetms52;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0 || prev != nums[i]) {
                prev = nums[i];
                if (count != i) {
                    nums[count] = prev;
                }
                count++;
            }
        }
        return count;
    }
}
