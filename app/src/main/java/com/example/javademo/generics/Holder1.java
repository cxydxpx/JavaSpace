package com.example.javademo.generics;//: generics/Holder1.java

class Automobile {

  final String str;
  final int i;

  Automobile(String str, int i) {
    this.str = str;
    this.i = i;
  }

  @Override
  public String toString() {
    return str + " -- " + i;
  }
}

public class Holder1 {

  public static void main(String[] args){

      Automobile automobile = new Automobile("auto",6);

      System.out.println(automobile);

  }
}
