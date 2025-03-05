# 25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.\
k is a positive integer and is less than or equal to the length of the linked list.\ 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.\
You may not alter the values in the list's nodes, only nodes themselves may be changed.

## Example1:
Input: head = [1,2,3,4,5], k = 2\
Output: [2,1,4,3,5]

## Example2:
Input: head = [1,2,3,4,5], k = 3\
Output: [3,2,1,4,5]

## Thinking:
- 遞迴解決
  - 但這次跟swap不一樣，不能固定兩個，所以打算用stack來解決反轉問題

## 學習：
- 解出來只有6% runtime beats，所以又到了claude檢討的時間。
- claude表示，反轉節點用不著stack，迴圈就可以搞定了...
  - 但與用stack不同，直接反轉需要檢查是否有k個節點
    - 用於檢查是否有k個節點的開銷仍然比stack操作push跟pop要少
    - 用於push的迴圈其實幾乎就等於檢查是否有k個節點了
    
### 指針反轉步驟
  ```
  ListNode prev = null;
  curr = head;
  for (int i = 0; i < k; i++) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
```


