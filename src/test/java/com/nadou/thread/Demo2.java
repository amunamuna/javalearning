package com.nadou.thread;

/**
 *@ClassName Demo2
 *@Description TODO
 *@Author amunamuna
 *@Date 2020/7/31 14:43
 *@Version 1.0
 **/
public class Demo2 {
  public static void main(String[] args) {

    Person p1 = new Person();
    p1.name="尾田荣一郞";
    Person.country="日本";
    Person p2 = new Person();
    p2.name="宫崎骏";
    p1.speak();
    p2.speak();
//    输出
//    尾田荣一郞...日本
//    宫崎骏...日本

  }
}

class Person{
  String name;
  static String country;

  public void speak(){
    System.out.println(name+"..."+country);
  }
}
