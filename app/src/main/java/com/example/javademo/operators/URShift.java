package com.example.javademo.operators;//: operators/URShift.java
// Test of unsigned right shift.

import static net.mindview.util.Print.print;

public class URShift {
    public static void main(String[] args) {
//        int i = -1;
//        print("1 == " + Integer.toBinaryString(i) + " == " + i);
//        i >>>= 24;
//        print("2 == " + Integer.toBinaryString(i) + " == " + i);
//        long l = -1;
//        print("3 == " + Long.toBinaryString(l)+ " == " + l);
//        l >>>= 10;
//        print("4 == " + Long.toBinaryString(l)+ " == " + l);
        short s = -1;
        print("5 == " + Integer.toBinaryString(s)+ " == " + s);
        s >>>= 10;
        print("6 == " + Integer.toBinaryString(s) + " == " + s);
//        byte b = -1;
//        print("7 == " + Integer.toBinaryString(b)+ " == " + b);
//        b >>>= 10;
//        print("8 == " + Integer.toBinaryString(b)+ " == " + b);
//        b = -1;
//        print("9 == " + Integer.toBinaryString(b)+ " == " + b);
//        print("0 == " + Integer.toBinaryString(b >>> 10));
    }
} /* Output:
11111111111111111111111111111111
1111111111111111111111
1111111111111111111111111111111111111111111111111111111111111111
111111111111111111111111111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
1111111111111111111111
*///:~
