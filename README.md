├── serializable
│   └── SerializableDemo.java
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
└── thread
    ├── MyAtomic.java   原子操作类
    ├── MyCountDownLatch.java 倒计时锁
    └── MyVolatile.java volatile 能保证内存可见




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

# Serializable
serialVersionUID https://blog.csdn.net/amunamuna/article/details/102624946

# @Slf4j

如果不想每次都写private final Logger logger = LoggerFactory.getLogger(当前类名.class); 可以用注解@Slf4j

引入依赖：
```
    <!--lombok @Slf4j注解-->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>${lombok-version}</version>
    </dependency>
```
