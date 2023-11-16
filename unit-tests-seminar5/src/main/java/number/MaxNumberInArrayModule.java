package number;

public class MaxNumberInArrayModule {
    /*
    Задание №1
    необходимо создать два модуля. Первый модуль генерирует список случайных чисел.
    Второй модуль находит максимальное число в этом списке.
    Написать юнит-тесты для каждого модуля, затем написать интеграционный
    тест, который проверяет, что оба модуля работают вместе правильно.
     */

    public int maxNumberInArray(int []array){
        int maxNumber = array[0];
        for (int i = 1; i < array.length -1; i++) {
            if(array[i] > maxNumber){
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }
}
