package com.nadou.thread;

/**
 * @ClassName ThisEscape
 * @Description 模拟 this 逃逸
 * @Author amunamuna
 * @Date 2021/6/3 10:29 上午
 * @Version 1.0
 **/
public class ThisEscape {
    // final 常量会保证在构造器内完成初始化（
    // 但是仅限于未发生 this 逃逸的情况下，具体可以看多线程对 final 保证可见性的实现，历史文章中有，后面我也会再写）
    final int i;
    //尽管实例变量有初始值，但是还实例化完成
    int j = 0;
    static ThisEscape obj;
    public ThisEscape() {
        i = 1;
        j = 1;
        // 将 this 逃逸抛出给线程 B
        obj = this;
    }

    public static void main(String[] args) {
        //线程A：模拟构造器中 this 逃逸，将未构造完全对象引用抛出
		/*Thread threadA = new Thread(new Runnable() {
		 @Override
		 public void run() {
		     //obj = new ThisEscape();
		 }
		});*/

        //线程B：读取对象引用，访问 i、j 变量
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //可能会发生初始化失败的情况解释：实例变量 i 的初始化被重排序到构造器外，此时 i 还未被初始化
                ThisEscape objB = obj;
                try {
                    System.out.println(objB.j);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：普通变量 j 未被初始化");
                }
                try {
                    System.out.println(objB.i);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：final 变量 i 未被初始化");
                }
            }
        });
        //threadA.start();
        threadB.start();
    }
}
