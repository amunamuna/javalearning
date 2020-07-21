package com.nadou.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@ClassName LoggerUtils
 *@Description TODO
 *@Author amunamuna
 *
 *
 *
 *@Date 2019/12/17 9:03 AM
 *@Version 1.0
 **/
public class LoggerUtils {
  public static <T> Logger getLogger(Class<T> clazz) {
    return LoggerFactory.getLogger(clazz);
  }

  /**
   * 打印到指定的文件下
   *
   * @param desc 日志文件名称
   * @return
   */
  public static Logger getLogger(LogFileName desc) {
    return LoggerFactory.getLogger(desc.getLogFileName());
  }
}
