package com.nadou.logback;

import org.apache.commons.lang3.StringUtils;

/**
 *@ClassName LogFileName
 *@Description TODO
 *@Author amunamuna
 *@Date 2019/12/17 9:02 AM
 *@Version 1.0
 **/
public enum LogFileName {
  //配置到logback.xml中的logger name="getNextHh"
  M_TRACE_LOGGER("mTraceLogger"),
  M_MONITOR_LOGGER("mMonitorLogger");

  private String logFileName;

  LogFileName(String fileName) {
    this.logFileName = fileName;
  }

  public String getLogFileName() {
    return logFileName;
  }

  public void setLogFileName(String logFileName) {
    this.logFileName = logFileName;
  }

  public static LogFileName getAwardTypeEnum(String value) {
    LogFileName[] arr = values();
    for (LogFileName item : arr) {
      if (null != item && StringUtils.isNotBlank(item.logFileName)) {
        return item;
      }
    }
    return null;
  }
}
