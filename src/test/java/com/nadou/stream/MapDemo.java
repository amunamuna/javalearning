package com.nadou.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amunamuna
 * map就是将对应的元素按照给定的方法进行转换。
 *2019/11/12 9:19
 **/
public class MapDemo {

  /**
   * 集合转换
   * @param students
   * @return
   */
  private static void testMap(List<Student> students) {
    //在地址前面加上部分信息，只获取地址输出
    List<String> addresses = students.stream().map(s ->"住址:"+s.getAddress()).collect(Collectors.toList());
    addresses.forEach(a ->System.out.println(a));
  }

  public static void main(String [] args) {

    Student s1 = new Student(1L, "肖战", 15, "浙江");
    Student s2 = new Student(2L, "王一博", 15, "湖北");
    Student s3 = new Student(3L, "杨紫", 17, "北京");
    Student s4 = new Student(4L, "李现", 17, "浙江");
    List<Student> students = new ArrayList<>();
    students.add(s1);
    students.add(s2);
    students.add(s3);
    students.add(s4);

    testMap(students);
  }

}
