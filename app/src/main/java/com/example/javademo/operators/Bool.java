package com.example.javademo.operators;//: operators/Bool.java
// Relational and logical operators.

import java.util.Random;

import static net.mindview.util.Print.print;

public class Bool {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        print("i = " + i);
        print("j = " + j);
        print("i > j is " + (i > j));
        print("i < j is " + (i < j));
        print("i >= j is " + (i >= j));
        print("i <= j is " + (i <= j));
        print("i == j is " + (i == j));
        print("i != j is " + (i != j));
        // Treating an int as a boolean is not legal Java:
//! print("i && j is " + (i && j));
//! print("i || j is " + (i || j));
//! print("!i is " + !i);
        print("(i < 10) && (j < 10) is "
                + ((i < 10) && (j < 10)));
        print("(i < 10) || (j < 10) is "
                + ((i < 10) || (j < 10)));
    }

    private String changeHex(byte[] bs) {
        char[] hexArray = "0123456789abcdef".toCharArray(); // 将字符串转换为一个字符数组
        char[] hexChars = new char[bs.length * 2]; // 创建一个bs字符数组两倍的字符数组
        for (int j = 0; j < bs.length; j++) {
            // 保持二进制补码的一致性
            // 因为byte类型字符是8bit的  而int为32bit 会自动补齐高位1
            // 所以与上0xFF之后可以保持高位一致性 当byte要转化为int的时候，高的24位必然会补1，
            // 这样，其二进制补码其实已经不一致了，&0xff可以将高的24位置为0，低8位保持原样，
            // 这样做的目的就是为了保证二进制数据的一致性。
            int v = bs[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return "";
    }

} /* Output:
i = 58
j = 55
i > j is true
i < j is false
i >= j is true
i <= j is false
i == j is false
i != j is true
(i < 10) && (j < 10) is false
(i < 10) || (j < 10) is false
*///:~
