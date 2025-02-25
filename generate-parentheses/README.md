# 22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

## Example1:

Input: n = 3\
Output: ["((()))","(()())","(())()","()(())","()()()"]

## Example2:

Input: n = 1\
Output: ["()"]

## Thinking:
- 可以用recursive，然候子問題切分來處理大部份的問題
- 但2+3跟2+2這種case，對於子問題來說有點例外，所以就另外處理他
- 不過這個答案只有5.8% runtime beats，所以應該是我的解法有問題

## 學習:
這題問過claude應該是要用backtrack來解的，用子問題分割會沒有效率.
那就留一下記錄，記得一下我曾經用其它角度寫出了解法

### backtrack 範例n=3：
```mermaid
flowchart LR
  root((n=3))-->A["( ,o1 ,c0"]
  A-->B["( ,o2 ,c0"]
  B-->C["( ,o3 ,c0"]
  C-->D[") ,o3 ,c1"]
  D-->E[") ,o3 ,c2"]
  E-->F[") ,o3 ,c3"]
  B-->G[") ,o2 ,c1"]
  G-->H["( ,o3 ,c1"]
  H-->I[") ,o3 ,c2"]
  I-->J[") ,o3 ,c3"]
  G-->K[") ,o2 ,c2"]
  K-->L["( ,o3 ,c2"]
  L-->M[") ,o3 ,c3"]
  A-->N[") ,o1 ,c1"]
  N-->O["( ,o2 ,c1"]
  O-->P["( ,o3 ,c1"]
  P-->Q[") ,o3 ,c2"]
  Q-->R[") ,o3 ,c3"]
  O-->S[") ,o2 ,c2"]
  S-->T["( ,o3 ,c2"]
  T-->U[") ,o3 ,c3"]
```
