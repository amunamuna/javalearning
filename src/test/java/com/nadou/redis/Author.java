package com.nadou.redis;

import java.io.Serializable;

/**
 * Created by amunamuna
 *2019/9/4 10:16
 **/
public class Author implements Serializable{

  String name;
  String intro_l;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIntro_l() {
    return intro_l;
  }

  public void setIntro_l(String intro_l) {
    intro_l = intro_l;
  }

  @Override
  public String toString() {
    return name+","+intro_l;
  }
}
