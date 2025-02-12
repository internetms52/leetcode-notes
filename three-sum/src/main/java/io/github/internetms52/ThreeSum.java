package io.github.internetms52;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return process(nums);
    }

    public HashMap<Integer, Set<Integer>> getValueIndexMap(int[] nums) {
        HashMap<Integer, Set<Integer>> valueIndexMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i])) {
                Set<Integer> indexSet = new HashSet<>(valueIndexMap.get(nums[i]));
                indexSet.add(i);
                valueIndexMap.put(nums[i], indexSet);
            } else {
                valueIndexMap.put(nums[i], Set.of(i));
            }
        }
        return valueIndexMap;
    }

    public List<List<Integer>> process(int[] nums) {
        List<List<Integer>> resultList = new ArrayList();
        HashMap<Integer, Set<Integer>> valueIndexMap = getValueIndexMap(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (valueIndexMap.containsKey(-sum)) {
                    Set<Integer> indexSet = valueIndexMap.get(-sum);
                    if (indexSet.size() > 0) {
                        List<Integer> indexList = new ArrayList<>(indexSet);
                        for (int k = 0; k < indexList.size(); k++) {
                            if (indexList.get(k) != i && indexList.get(k) != j) {
                                int target = nums[indexList.get(k)];
                                resultList.add(List.of(nums[i], nums[j], target));
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (resultList.size() > 1) {
            return removeDuplicateList(resultList);
        } else {
            return resultList;
        }
    }

    public List<List<Integer>> removeDuplicateList(List<List<Integer>> numList) {
        List<List<Integer>> resultList = new ArrayList(numList);
        for (int i = 0; i < numList.size(); i++) {
            HashSet<Integer> iSet = new HashSet<>(numList.get(i));
            for (int j = i + 1; j < numList.size(); j++) {
                HashSet<Integer> jSet = new HashSet<>(numList.get(j));
                if (iSet.equals(jSet)) {
                    resultList.remove(numList.get(i));
                    break;
                }
            }
        }
        return resultList;
    }

}
