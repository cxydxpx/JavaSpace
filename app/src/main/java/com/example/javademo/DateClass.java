package com.example.javademo;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DateClass {

    public static void main(String[] args) {

        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
//        System.out.println(""+ c.get(Calendar.DAY_OF_WEEK));
//        System.out.println(""+ c.get(Calendar.HOUR_OF_DAY));
//        System.out.println(""+ c.get(Calendar.MINUTE));
//        System.out.println(""+ c.get(Calendar.SECOND));
//        System.out.println(""+ c.get(Calendar.HOUR_OF_DAY));
//        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long l = System.currentTimeMillis() - c.getTime().getTime();

        long l1 = l / 1000 / 60 / 60;
//        System.out.println("" + c.get(Calendar.DAY_OF_WEEK));

        // 1585738952604 -- 68552604 -- 19
//        System.out.println("" + System.currentTimeMillis() + " -- " + l + " -- " + l1);


        // 1585670400000
        // 1585670400000
        // 1585670400000
        // 1585670400000

        //1585756800000

        mDatas.add("4");
        mDatas.add("3");
        mDatas.add("2");
        mDatas.add("1");
//        System.out.println(mDatas.toString());

//        System.out.println(1 << 2);
//        System.out.println(1 << 3);
//        System.out.println(1 << 4);
//        System.out.println(1 << 8);
//        System.out.println(1 << 16);

//        Value value = new Value();
//        Value value1 = new Value();
//        value = value1;

//        value.i = value1.i = 10;
//
//        System.out.println(value == value1);
//        System.out.println(value.equals(value1));


        long ii = 1585807346839l + 3*24 * 60 * 60 * 1000;
//        long ii = 1585807346839l;

        final Calendar c22 = Calendar.getInstance();
        c22.setTimeInMillis(ii);
        c22.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c22.set(Calendar.HOUR_OF_DAY, 0);
        c22.set(Calendar.MINUTE, 0);
        c22.set(Calendar.SECOND, 0);
        c22.set(Calendar.MILLISECOND, 0);

//        System.out.println("" + (ii - c22.getTime().getTime()));

        // 50546839
        // 50546839
        // 50546839


        int i = 1;
        System.out.println(i << 16);


    }

    static List<String> mDatas = new ArrayList<String>() {
        @Override
        public boolean add(String o) {


            if (o.equals("3")) {
                this.add(0, o);
                return true;
            } else {
                return super.add(o);
            }

        }
    };

}

class Value {
    int i;
}