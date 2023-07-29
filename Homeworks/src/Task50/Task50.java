package Task50;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Задача 1
//Программисты, как вы уже знаете, постоянно учатся, а в общении между собой используют весьма специфический язык.
// Чтобы систематизировать ваш пополняющийся профессиональный лексикон, мы придумали эту задачу.
//
//Напишите программу создания небольшого словаря сленговых программистских выражений,
// чтобы она потом по запросу возвращала значения из этого словаря.
//
//Формат входных данных
//Файл dict.txt
//В первой строке задано одно целое число n — количество слов в словаре.
//
//В следующих n строках записаны слова и их определения, разделенные двоеточием и символом пробела.
//
//Ввод с клавиатуры
//В первой строке записано целое число m — количество поисковых слов, чье определение нужно вывести.
//
//В следующих m строках записаны сами слова, по одному на строке.
//
//Формат выходных данных
//Для каждого слова, независимо от регистра символов, если оно присутствует в словаре, необходимо вывести на экран его определение.
//
//Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
//
//Примечание 1
//Мини-словарь для начинающих разработчиков можно посмотреть тут.
//
//Примечание 2
//Гарантируется, что в определяемом слове или фразе отсутствует двоеточие (:), следом за которым идёт пробел.
//
//Пример входных данных
//5
//Змея: язык программирования Python
//Баг: от англ. bug — жучок, клоп, ошибка в программе
//Конфа: конференция
//Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода.
//Бета: бета-версия, приложение на стадии публичного тестирования
//3
//Змея
//Жаба
//костыль
//Пример выходных данных
//язык программирования Python
//Не найдено
//код, который нужен, чтобы исправить несовершенство ранее написанного кода
public class Task50 {

  public static void main(String[] args) {
    Scanner scanner;
    try {
      scanner = new Scanner(new File("res/dict.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден: " + e.getMessage());
      return;
    }
    int n = scanner.nextInt();
    scanner.nextLine();
    Map<String, String> dictionary = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      String[] cells = line.split(": ");
      try {
        String word = cells[0];
        String slang = cells[1];
        if (!dictionary.containsKey(word)) {
          dictionary.put(word.toLowerCase(), slang);
        }
        dictionary.get(word);
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.out.println("Некорректная строка файла: " + line);
      }
    }
    scanner.close();

    scanner = new Scanner(System.in);

    int m = scanner.nextInt();
    scanner.nextLine();
    List<String> slangs = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      String word = scanner.nextLine().toLowerCase();
      slangs.add(dictionary.getOrDefault(word, "Не найдено"));
    }
    for (String slang : slangs) {
      System.out.println(slang);
    }
  }
}
