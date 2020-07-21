package com.nadou.stream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by amunamuna
 * anyMatch：Stream 中任意一个元素符合传入的 predicate，返回 true
   allMatch：Stream 中全部元素符合传入的 predicate，返回 true
   noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
 *2019/11/12 9:37
 **/

public class MatchDemo {
  @Test
  public void testMatch() {
    Student s1 = new Student(1L, "肖战", 15, "浙江");
    Student s2 = new Student(2L, "王一博", 15, "湖北");
    Student s3 = new Student(3L, "杨紫", 17, "北京");
    Student s4 = new Student(4L, "李现", 17, "浙江");
    List<Student> students = new ArrayList<>();
    students.add(s1);
    students.add(s2);
    students.add(s3);
    students.add(s4);
    Boolean anyMatch = students.stream().anyMatch(s ->"湖北".equals(s.getAddress()));
    if (anyMatch) {
      System.out.println("有湖北人");
    }
    Boolean allMatch = students.stream().allMatch(s -> s.getAge()>=15);
    if (allMatch) {
      System.out.println("所有学生都满15周岁");
    }
    Boolean noneMatch = students.stream().noneMatch(s -> "杨洋".equals(s.getName()));
    if (noneMatch) {
      System.out.println("没有叫杨洋的同学");
    }
  }

}
