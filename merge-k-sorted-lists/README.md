# 23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

## Example1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]\
Output: [1,1,2,3,4,4,5,6]\
Explanation: The linked-lists are:\
[\
1->4->5,\
1->3->4,\
2->6\
]\
merging them into one sorted list:\
1->1->2->3->4->4->5->6

## Example2:
Input: lists = []\
Output: []

## Example3:
Input: lists = [[]]\
Output: []
## Thinking:
- 理論上merge k sorted list 一樣可以被遞迴分解成單一問題
- 然候我就簡單的用了merge two sorted list + for loop

## 學習:
- 解答寫出來只有5% runtime beats，所以表示這一題只是用merge two sorted list 為基礎考其它東西.
- 問claude檢討
  - 使用迴圈遍歷所有的清單會造成某一個長的list不斷與其它列表合併的問題，造成效率很低
  - 應該使用分割的方式進行處理，一半一半直到無法切分，保證所有的列表的數量足夠小

### BigO分析
- Sequential
  - O(Σ(k-i+1)·nᵢ)，其中i從1~k
    - Σ(k-i+1)
      - k-i
        - 元素合併成同一個列表後，該元素所形成的新列表同樣會被後續的所有列表處理
        - 也就是當n1+n2後，與n3合併的次數會是n1+n2+n3
        - 簡單的說就是在合併前，其元素不會參與合併，而合併後其所有元素都會參與之後的所有合併
        - 所以是k-1，而k個元素的第i個就是k-i
      - +1 
        - 初始讀取的那一次
    - nᵢ
      - (k-i+1)是每一個元素跟其它清單處理的次數，並沒有算進清單的長度，所以這個nᵢ是要納入清單長度
      - 也就是第i個列表所擁有的清單長度n
- Divide
  ```
         最终结果
         /      \
     L1234      L5678
     /    \     /    \
   L12    L34  L56    L78
   / \    / \  / \    / \
  L1 L2  L3 L4 L5 L6  L7 L8
  ```
  - O(log(k)·Σnᵢ)
    - log(k)
      - 每次遞迴將問題減半，所以是log(k)次
    - Σnᵢ
      - 所有元素都被处理log(k)次，所以公式变为：n₁·log(k) + n₂·log(k) + ... + nₖ·log(k)
      - log(k)·(n₁ + n₂ + ... + nₖ) = log(k)·Σnᵢ

### 結論
 - 搞了這麼多就是要注意，在設計演算法的時候要考慮每一個元素的處理次數，避免待處理元素的成長速度過快