package number;

import java.util.Random;

public class RandomNumberArrayModule {
    /*
    Задание №1
    необходимо создать два модуля. Первый модуль генерирует список случайных чисел.
    Второй модуль находит максимальное число в этом списке.
    Написать юнит-тесты для каждого модуля, затем написать интеграционный
    тест, который проверяет, что оба модуля работают вместе правильно.
     */
    Random random = new Random();
    public int []randomNumberArray(int size){
        int [] array = new int [size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
