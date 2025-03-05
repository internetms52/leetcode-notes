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
  - 遞迴條件，current.next.next以及current.next.next.next不是null
- 節點替換(A-B-C-D)
  - Snapshot B
  - A.next -> C-D
  - B.next -> A
- A.next -> C-D 正好可以拿來遞迴

