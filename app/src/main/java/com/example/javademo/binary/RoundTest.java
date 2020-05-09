package com.example.javademo.binary;

public class RoundTest {

    public static void main(String[] args) {

        /**
         * 四舍五入的解决思路
         * 1.比如获取小数点后两位的四舍五入，那么就先*100将小数点后两位转换为整数，
         *   传入Math.round()，Math.round()方法获取的是一个整数型的四舍五入结果
         * 2.再*0.01 将位数归位
         */
        float i = (float) (Math.round(36.5623222 * 10) * 0.1d);

        System.out.println("四舍五入值 : " + i);

        System.out.println("四舍五入值：Math.round(36.56）== " + Math.round(36.56 * 10));
        System.out.println("四舍五入值：Math.round(36.56 * 10）== " + Math.round(36.56 * 10));
        System.out.println("四舍五入值：Math.round(36.56 * 10） * 0.1d == " + Math.round(36.56 * 10) * 0.1d);

        /**
         *  四舍五入值：Math.round(36.56）== 366
         *  四舍五入值：Math.round(36.56 * 10）== 366
         *  四舍五入值：Math.round(36.56 * 10） * 0.1d == 36.6
         */

    }





}
