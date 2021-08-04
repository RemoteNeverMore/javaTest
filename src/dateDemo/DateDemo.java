package dateDemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-05-06 14:26
 **/
public class DateDemo {

    public static void main(String[] args) {
//        getCalendar();
        minutesBeforeNow(-10000);
        hoursBeforeNow(2);
        yearsBeforeNow(1);
    }


    private static void getCalendar(){
        Calendar c  = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, (c.get(Calendar.HOUR_OF_DAY) - 1));//HOUR_OF_DAY 指一天中的小时

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("当前系统时间：" + sdf.format(new Date()));

        System.out.println("一小时前的系统时间：" + sdf.format(c.getTime()));
    }


    private static void minutesBeforeNow(int time){
        // 日期操作类
        Calendar calendar = Calendar.getInstance();
        // 当前时间
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:59");
            calendar.add(Calendar.MINUTE, -time);
        System.out.println(sdf.format(calendar.getTime()));
    }

    private static void yearsBeforeNow(int time){
        // 日期操作类
        Calendar calendar = Calendar.getInstance();
        // 当前时间
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:00");
        calendar.add(Calendar.YEAR, -time);
        System.out.println(sdf.format(calendar.getTime()));
    }


    private static void hoursBeforeNow(int time){
//        // 日期操作类
//        Calendar calendar = Calendar.getInstance();
//        // 当前时间
//        calendar.setTime(new Date());
//        SimpleDateFormat sdf = new SimpleDateFormat(
//                "yyyy-MM-dd HH:mm:59");
//            calendar.add(Calendar.HOUR, -time);
//        System.out.println(sdf.format(calendar.getTime()));

    }
}
