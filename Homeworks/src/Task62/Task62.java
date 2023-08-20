package Task62;

import java.util.Scanner;

//Задача 1
//Напишите, рекурсивный метод public static String reverse(int x),
// который будет возвращать строку,
// содержащую десятичные цифры числа в обратном порядке (развернёт число).
public class Task62 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    // System.out.println(x + " числа в обратном порядке: " + reverse(x));
    if (x < 0) { //делаем число положительным
      x *= -1;
    }
    int number = x % 10;
    int number2 = number;
    x = x / 10;

    while (x > 0) {
      number = x % 10;
      x /= 10;
      number2 *= 10;
      number2 += number;
    }
    String n = Integer.toString(number2);
    System.out.println(n);

  }
}
