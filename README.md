# 结构目录

```shell
├── serializable
│   └── SerializableDemo.java 序列化
├── stream
│   ├── DistinctDemo.java
│   ├── FilterDemo.java
│   ├── LimitDemo.java
│   ├── MapDemo.java
│   ├── MatchDemo.java
│   ├── ReduceDemo.java
│   ├── SkipDemo.java
│   ├── SortedDemo.java
│   └── Student.java
├── math
│   └── ArithmeticUtils.java 用于高精确处理常用的数学运算
└── thread
    ├── MyAtomic.java 原子操作类:CAS保证原子操作,value值被volatile修饰,保证内存可见.
    ├── MyCountDownLatch.java 倒计时锁:AQS
    ├── MyCyclicBarrier.java 让一组线程等待至某个状态之后再全部同时执行
    ├── MyCallable.java 使用FutureTask提交callable
    ├── MyFutureAndCallable.java 使用ExecutorService提交callable
    ├── MyReadWriteLock.java 读写锁
    ├── MySemaphone.java 用來控制并发线程数
    └── MyVolatile.java volatile 能保证内存可见



```

# stream
```

Stream类的类结构图，里面包含了大部分的中间和终止操作。

中间操作主要有以下方法（此类型方法返回的都是Stream）：
map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered

终止操作主要有以下方法：
forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator


Stream作为java8的新特性，基于lambda表达式，是对集合对象功能的增强，它专注于对集合对象进行各种高效、便利的聚合操作或者大批量的数据操作，提高了编程效率和代码可读性。

Stream的原理：将要处理的元素看做一种流，流在管道中传输，并且可以在管道的节点上处理，包括过滤筛选、去重、排序、聚合等。元素流在管道中经过中间操作的处理，最后由最终操作得到前面处理的结果。

集合有两种方式生成流：

stream() − 为集合创建串行流
parallelStream() - 为集合创建并行流

```
