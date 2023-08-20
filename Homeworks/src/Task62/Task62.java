package Task62;

import java.util.InputMismatchException;
import java.util.Scanner;

//Задача 1
//Напишите, рекурсивный метод public static String reverse(int x),
// который будет возвращать строку,
// содержащую десятичные цифры числа в обратном порядке (развернёт число).
public class Task62 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      int x = scanner.nextInt();
      System.out.println(reverse(x));
    } catch (InputMismatchException e) {
      System.out.println("Некорректный ввод числа.");
    }
  }

  public static String reverse(int x) {
    if (x < 0) {
      x *= -1;
    }

    if (x < 10) {
      return Integer.toString(x);
    } else {
      int lastDigit = x % 10;
      return lastDigit + reverse(x / 10);
    }
  }
}