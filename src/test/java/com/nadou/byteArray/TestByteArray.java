package com.nadou.byteArray;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *@ClassName Test
 *@Description TODO
 *@Author amunamuna
 *@Date 2019/11/25 10:04 PM
 *@Version 1.0
 **/
public class TestByteArray {

  public static void main(String[] args) throws UnsupportedEncodingException {
    String hexString= "008f";
    byte[] bytes = hexString.getBytes();
//    System.out.println(bytes.toString());
//    System.out.println(Arrays.toString(bytes));
//    System.out.println(Arrays.toString(phone.getBytes()));
    System.out.println(Arrays.toString(hexToByte(hexString)));
    System.out.println(Arrays.toString("11".getBytes()));
    System.out.println(Arrays.toString((new String(hexToByte(hexString))+"11").getBytes()));
    System.out.println(Arrays.toString(byteMerger(hexToByte(hexString),"11".getBytes())));
    System.out.println(Arrays.toString(new String(hexToByte(hexString)).getBytes()));
  }

  //合并字节数组
  public static byte[] byteMerger(byte[] bt1, byte[] bt2){
    byte[] bt3 = new byte[bt1.length+bt2.length];
    System.arraycopy(bt1, 0, bt3, 0, bt1.length);
    System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
    return bt3;
  }
  /**
   * hex转byte数组
   * @param hex
   * @return
   */
  public static byte[] hexToByte(String hex){
    int m = 0, n = 0;
    int byteLen = hex.length() / 2; // 每两个字符描述一个字节
    byte[] ret = new byte[byteLen];
    for (int i = 0; i < byteLen; i++) {
      m = i * 2 + 1;
      n = m + 1;
      int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
      ret[i] = Byte.valueOf((byte)intVal);
    }
    return ret;
  }

  /**
   * byte数组转hex
   * @param bytes
   * @return
   */
  public static String byteToHex(byte[] bytes){
    String strHex = "";
    StringBuilder sb = new StringBuilder("");
    for (int n = 0; n < bytes.length; n++) {
      strHex = Integer.toHexString(bytes[n] & 0xFF);
      sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
    }
    return sb.toString().trim();
  }

  /**
   * 16进制的字符串表示转成字节数组
   *
   * @param hexString
   * 16进制格式的字符串
   * @return 转换后的字节数组
   **/

  public static byte[] toByteArray(String hexString) {
    hexString = hexString.toLowerCase();
    final byte[] byteArray = new byte[hexString.length() / 2];
    int k = 0;
    for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
      byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
      byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
      byteArray[i] = (byte) (high << 4 | low);
      k += 2;
    }
    return byteArray;
  }
  /**
   * 字节数组转成16进制表示格式的字符串
   *
   * @param byteArray
   * 需要转换的字节数组
   * @return 16进制表示格式的字符串
   **/

  public static String toHexString(byte[] byteArray) {
    String str = null;
    if (byteArray != null && byteArray.length > 0) {
      StringBuffer stringBuffer = new StringBuffer(byteArray.length);
      for (byte byteChar : byteArray) {
        stringBuffer.append(String.format("%02X", byteChar));
      }
      str = stringBuffer.toString();
    }
    return str;
  }
}
