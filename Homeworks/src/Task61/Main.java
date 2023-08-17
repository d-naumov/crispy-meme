package Task61;


//Задача 1
//Найти минимальное чётное число в последовательности положительных чисел или вывести -1,
// если такого числа не существует.
//
//Оценить временную и пространственную сложность алгоритма.
public class Main {

  public static void main(String[] args) {                   // time = O(n)    space = O(1)

    int[] array = {55, 13, 6, 43, 87, 99, 47, 4, 15, 67};    //  O(1)            O(1)

    int min = array[0];                                      // O(1)             O(1)
    for (int j : array) {                                    // O(n)             O(1)
      if (j % 2 == 0) {                                      // O(1)             O(1)
        if (j < min) {                                       // O(1)             O(1)
          min = j;                                           // O(n)             O(1)
        }
      }
    }
    if (min % 2 == 0) {                                      // O(1)             O(1)
      System.out.println("Минимальное четное число: " + min);// O(1)             O(1)
    } else {
      System.out.println("-1");                              // O(1)             O(1)
    }
  }
}