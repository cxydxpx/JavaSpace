package com.example.javademo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClientDemo {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("127.0.0.1", 9999);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //通过标准输入流获取字符流

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

            while (true) {

                String str = bufferedReader.readLine();

                bufferedWriter.write(str);

                bufferedWriter.write("\n");

                bufferedWriter.flush();

            }


        } catch (IOException e) {

            e.printStackTrace();

        }


    }

}
