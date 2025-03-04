# 24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.\
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

## Example1:
Input: head = [1,2,3,4]\
Output: [2,1,4,3]

## Example2:
Input: head = []\
Output: []

## Example3:
Input: head = [1]\
Output: [1]

## Example4:
Input: head = [1,2,3]\
Output: [2,1,3]

## Thinking:
- 遞迴解決
  - 遞迴條件，current.next.next以及current.next.next.next不是null
- 節點替換(A-B-C-D)
  - Snapshot B
  - A.next -> C-D
  - B.next -> A
- A.next -> C-D 正好可以拿來遞迴

