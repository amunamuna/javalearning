package com.nadou.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amunamuna
 *2019/11/11 14:06
 **/
public class FilterDemo {

  /**
   * 集合的筛选
   * @param students
   * @return
   */
  private static List<Student> testFilter(List<Student> students) {
    //筛选年龄大于15岁的学生
//        return students.stream().filter(s -> s.getAge()>15).collect(Collectors.toList());
    //筛选住在浙江省的学生
    return students.stream().filter(s ->"浙江".equals(s.getAddress())).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    Student s1 = new Student(1L, "肖战", 15, "浙江");
    Student s2 = new Student(2L, "王一博", 15, "湖北");
    Student s3 = new Student(3L, "杨紫", 17, "北京");
    Student s4 = new Student(4L, "李现", 17, "浙江");
    List<Student> students = new ArrayList<>();
    students.add(s1);
    students.add(s2);
    students.add(s3);
    students.add(s4);

    List<Student> streamStudents = testFilter(students);
    streamStudents.forEach(System.out::println);
  }
}
