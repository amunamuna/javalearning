package com.nadou.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amunamuna
 *2019/9/4 10:16
 **/
@Data
public class Author implements Serializable{

  String name;
  String intro_l;

  @Override
  public String toString() {
    return name+","+intro_l;
  }
}
