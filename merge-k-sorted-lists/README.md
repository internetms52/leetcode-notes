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
