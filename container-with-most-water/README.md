# 11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

## 思考一
### 1 
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 8 | --> | 1 |
| 8 | 6 | --> | 6 |
| 6 | 2 | --> | 2 |
| 2 | 5 | --> | 2 |
| 5 | 4 | --> | 4 |
| 4 | 8 | --> | 4 |
| 8 | 3 | --> | 3 |
| 3 | 7 | --> | 3 |

### 2 
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 6 | --> | 1 |
| 8 | 2 | --> | 2 |
| 6 | 5 | --> | 5 |
| 2 | 4 | --> | 2 |
| 5 | 8 | --> | 5 |
| 4 | 3 | --> | 3 |
| 8 | 7 | --> | 7 |

### 3 
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 2 | --> | 1 |
| 8 | 5 | --> | 5 |
| 6 | 4 | --> | 4 |
| 2 | 8 | --> | 2 |
| 5 | 3 | --> | 3 |
| 5 | 7 | --> | 1 |

### 4
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 5 | --> | 1 |
| 8 | 4 | --> | 5 |
| 6 | 8 | --> | 4 |
| 2 | 3 | --> | 2 |
| 5 | 7 | --> | 3 |

### 5
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 4 | --> | 1 |
| 8 | 8 | --> | 8 |
| 6 | 3 | --> | 3 |
| 2 | 7 | --> | 2 |

### 6
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 8 | --> | 1 |
| 8 | 3 | --> | 3 |
| 6 | 7 | --> | 6 |

### 7
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 3 | --> | 1 |
| 8 | 7 | --> | 7 |

### 8
| i | j | --> | s |
| --- | --- | --- | --- |
| 1 | 7 | --> | 1 |

## 思考二
r = min(i,j) * w
w為間距，間距有上限，固定i,r/h[i]會得到可能的w
i跟j取小，所以就算j比較大也是算i，除非j比較小
如果j比較小，那他也不可能乘起來更大，所以如果出來可能的w超過最大的w可以直接放棄
```
int maxW = height.length - 1;
if (height[i] != 0 && result / height[i] > maxW) {
    continue;
}
```

