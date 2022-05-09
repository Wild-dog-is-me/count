package com.my.count.config;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/05/06/3:40 PM
 */

public class demo {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      int[] len = new int[3];
      System.out.println("请输入三角形的三边长度：每输入一个，再换行输入");
      for (int i = 0; i < len.length; i++) {
        len[i] = scanner.nextInt();
      }
      System.out.println(BooleanShape(len[0], len[1], len[2]));
    }
    catch (InputMismatchException e){
      System.out.println("请输入正确数字");
    }

  }

  public static String BooleanShape(int a, int b, int c) {
    if (a + b > c && a + c > b && b + c > a) {
      if (a == b && b == c && c == a)
        return "等边三角形";
      else if (a == b || b == c || c == a)
        return "等腰三角形";
      else
        return "一般三角形";
    }
    return "无法构成三角形";
  }
}
