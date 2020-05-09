package com.example.javademo.binary;


import android.os.Handler;
import android.os.Message;

public class TimeTest {


    private static final String TAG = TimeTest.class.getSimpleName();

    public static void main(String[] args) {


//        int xx = 0x4A1EB629;
//        String cardNum = String.format("%010d", 23l);

        String val = "4015586759";
        Integer cardInt = Integer.parseInt(val, 16);//


        System.out.println(cardInt);

        for (int i = 0; i < 10; i++) {
            if (TimeUtils.isFastDoubleClick(1000)) {

//                System.out.println(" i = " + i);
            }
        }

    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

            }
        }
    }


}
