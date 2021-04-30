### hash表的存储
- 当存基础类型的时，不会复制，只保存基础数据的地址。
- hashTable是按值传递的，例如Integer a = 100; Integer = 100; a == b 是false。但是将a加入hash表中，查找b也会存在。
### treeMap 
treeMap是有序表，如果存储自定义类型需要定义比较器，否则会出错，因为无法进行排序。