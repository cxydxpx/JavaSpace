package com.example.javademo.binary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LeftMoveDemo {

    public static long WeeHoursTime() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime().getTime();
    }

    public static String WeekData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));//1-7 从礼拜日开始
        return mWay;
    }

    public static void main(String[] args) {


        int i9 = 34523847 % 10000;

        System.out.println(i9 + "");

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//24小时制

//        Date date2 = new Date();
//        date2.setTime(1586339035000l);
//        System.out.println(WeekData());

//        for (int i = 0; i < 10; i++) {
//            System.out.println("  " + i);
//            if (i == 5){
//                return;
//            }
//        }
//
//        System.out.println("执行到这不");


//        System.out.println(1 % 5 + 1);
//        System.out.println(2 % 5 + 1);
//        System.out.println(3 % 5 + 1);
//        System.out.println(4 % 5 + 1);
//        System.out.println(5 % 5 + 1);
//        System.out.println(1 % 5 + 1);


//        System.out.println(Integer.toBinaryString(32));
//        System.out.println(Integer.toBinaryString(0x0f));

//        int i = 32 & 0x0f;
//        System.out.println(i);
//
//        int i2 = 32 >> 4 & 0x0f;
//        System.out.println(i2);


        byte i = 0 << 4 | 0;
//        System.out.println("  " + i);

        byte i1 = 0 << 4 | 1;
//        System.out.println("  " + i1);

        byte i2 = 0 << 4 | 2;
//        System.out.println("  " + i2);

        byte i3 = 1 << 4 | 0;
//        System.out.println("  " + i3);

        byte i4 = 1 << 4 | 1;
//        System.out.println("  " + i4);

        byte i5 = 1 << 4 | 2;
//        System.out.println("  " + i5);

        byte i6 = 2 << 4 | 0;
//        System.out.println("  " + i6);

        byte i7 = 2 << 4 | 1;
//        System.out.println("  " + i7);

        byte i8 = 2 << 4 | 2;
//        System.out.println("  " + i8);

//        int i = 0x3 << 30;

//        System.out.println(Integer.toBinaryString(i) + " == " + i);

//        byte[] a = new byte[10];
//        /**
//         * 原码 11111111
//         * 反码 10000000
//         * 补码 10000001
//         */
//        a[0] = -127;
//        /**
//         * 原码 10000000
//         * 反码 11111111
//         * 补码 10000000
//         */
//        a[1] = -128;
//        System.out.println(a[0]);// -127
//        int c = a[0] & 0xFF;
//        /**
//         * 运算前 byte会转为int
//         *      11111111 11111111 11111111 10000001
//         *  &   00000000 00000000 00000000 11111111
//         *  -----------------------------------------
//         *      00000000 00000000 00000000 10000001(129)
//         */
//        System.out.println(c); // 129
//        /**
//         * 运算前 byte会转为int
//         *              11111111 11111111 11111111 10000001
//         *         <<   11111111 11111111 11111111 00000010
//         *  强转为byte，丢失高24位 00000010 = 2
//         *
//         */
//        a[2] = (byte) (a[0]<<1);
//        System.out.println(a[2]);
//        /**
//         * 运算前 byte会转为int
//         *              11111111 11111111 11111111 10000001
//         *         >>   11111111 11111111 11111111 11000001
//         *  强转为byte，丢失高24位 11000001 = -64
//         *
//         */
//        a[3] = (byte) (a[0]>>1);
//        System.out.println(a[3]);

    }

    private String changeHex(byte[] bs) {
        char[] hexArray = "0123456789abcdef".toCharArray(); // 将字符串转换为一个字符数组
        char[] hexChars = new char[bs.length * 2]; // 创建一个bs字符数组两倍的字符数组
        for (int j = 0; j < bs.length; j++) {
            // 保持二进制补码的一致性 因为byte类型字符是8bit的
            // 而int为32bit 会自动补齐高位1  所以与上0xFF之后可以保持高位一致性
            // 当byte要转化为int的时候，高的24位必然会补1，
            // 这样，其二进制补码其实已经不一致了，
            // &0xff可以将高的24位置为0，低8位保持原样，
            // 这样做的目的就是为了保证二进制数据的一致性。
            int v = bs[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }

        return "";
    }

    /**
     *   11111111 11111111 11111111 11110011
     *   00000000 00000000 00000000 11111111 & (0xFf)
     *   ----------------------------------------
     *   00000000 00000000 00000000 11110011
     */

}
