# 19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.

## Example1:
Input: head = [1,2,3,4,5], n = 2\
Output: [1,2,3,5]

## Example2:
Input: head = [1], n = 1\
Output: []

## Example3:
Input: head = [1,2], n = 1\
Output: [1]

## Thinking:
- 因為是倒數n節點，所以不先知道總共有幾個節點沒辦法知道倒數n節點是哪一個
- 倒數轉正數n節點算法研究測試
  - max-(n-1)=正數
  - 5-(2-1)=4
  - 4-(2-1)=3
  - 2-(1-1)=2
- 處理所有狀況
  - prev==null && next!=null
  - prev==null && next==null
  - prev!=null && next!=null
  - prev!=null && next==null