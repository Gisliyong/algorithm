### 图的表示方式
- 邻接矩阵
  > 利用与顶点数相等行列的矩阵表示，两个顶点如果连通值为权重，否则为无穷大。
- 邻接表法
  > 记录每个结点的邻居结点，可采用链表、HashMap来表示。
### 图结构
```java
Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;
```
```java
Node {
    int value; // 结点值
    int in; // 入度
    int out; // 出度
    ArrayList<Node> nexts; // 当前结点邻结点
    ArrayList<Edge> edges; // 当前节点邻接边
}
```
```java
Edge {
    int weight; // 权重
    Node from; // 出发
    Node to; // 结尾
}
```
###图算法
- TIPS
> 在练习题目的时候一般会把题目的图转换为自己习惯的结构，按平时的算法结题。
- 宽度优先遍历
> 需要使用队列结构，并且需要一个集合将用于记录访问情况（图可能存在回路，可能无法完成宽度遍历）。