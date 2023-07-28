package pizzeria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Pizza {

  private static final String SEP = ",";
  // Map<НазваниеПиццы, Map<Размер, Стоимость>>
  private static final Map<String, Map<String, Double>> prices = readFromCsv("res/pizzas.csv");

  private final String name;
  private final String size;
  private final double price;

  public Pizza(String name, String size) {
    if (!prices.containsKey(name)) {
      throw new IllegalArgumentException("Некорректное название пиццы: " + name);
    }
    this.name = name;
    Map<String, Double> sizeToPrice = prices.get(name); // стоимость в зависимости от размера
    if (!sizeToPrice.containsKey(size)) {
      throw new IllegalArgumentException("Некорректный размер: " + size);
    }
    this.size = size;
    price = sizeToPrice.get(size);
  }

  private static String readValueFromSet(Scanner scanner, Set<String> values, String title) {
    System.out.println("Выберите " + title + ":");
    for (String name : values) {
      System.out.println("- " + name);
    }
    System.out.print("Введите " + title + ": ");
    String value = scanner.nextLine();
    while (!values.contains(value)) {
      System.out.println("Некорректное " + title + " пиццы: " + value);
      System.out.print("Введите " + title + ": ");
      value = scanner.nextLine();
    }
    return value;
  }

  // фабричный метод, прочитает параметры пиццы в интерактивном режиме
  public static Pizza readInteractive(Scanner scanner) {
    String name = readValueFromSet(scanner, prices.keySet(), "название");
    String size = readValueFromSet(scanner, prices.get(name).keySet(), "размер");
    return new Pizza(name, size);
  }

  private static Map<String, Map<String, Double>> readFromCsv(String filename) {
    // CSV - comma separated values - значения, разделённые запятыми -
    // самый простой формат таблиц.
    Map<String, Map<String, Double>> result = new HashMap<>();
    File pizzasFile = new File(filename);
    try {
      Scanner scanner = new Scanner(pizzasFile);
      while (scanner.hasNextLine()) {
        // line = "Capricciosa,Small,7.5"
        String line = scanner.nextLine();
        // cells = ["Capricciosa", "Small", "7.5"]
        String[] cells = line.split(SEP);
        try {
          // pizza = "Capricciosa"
          String pizza = cells[0];
          // size = "Small"
          String size = cells[1];
          // price = Double.parseDouble("7.5") = 7.5
          double price = Double.parseDouble(cells[2]);
          if (!result.containsKey(pizza)) { // пицца встретилась первый раз
            result.put(pizza, new HashMap<>()); // кладём ей пока пустой словарь "размер-цена"
          }
          // теперь словарь "размер-цена" для пиццы точно есть в нашем словаре
          result.get(pizza).put(size, price);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
          System.out.println("Некорректная строка файла: " + line);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Не найден файл: " + e);
    }
    return result;
  }
}