package com.nadou.annotation;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Author amunamuna
 * @Date 2021/7/5 2:28 下午
 * @Version 1.0
 **/

public class Test {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.DECEMBER, 31);

        Date testDate = calendar.getTime();

        SimpleDateFormat dtf = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("2019-12-31 转 YYYY-MM-dd 格式后 " + dtf.format(testDate));
    }

}
