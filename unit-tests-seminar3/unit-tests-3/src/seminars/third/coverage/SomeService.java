package seminars.third.coverage;
public class SomeService {

    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
     */
    public String fizzBuzz(int i) {

        if (i % 15 == 0) {
            return "FizzBuzz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        if (i % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(i); // вместо этого напишите свою реализацию
    }

    /**
     * 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6, и false - если 6 нет ни в начале ни в конце массива
     */
    public boolean firstLast6(int[] nums) {
        if (nums[0] == 6) {
            return true;
        }
        if (nums[nums.length - 1] == 6) {
            return true;
        }
        return false;
    }


    /**
     * 3.3. Метод подсчета скидки
     */
    public double calculatingDiscount(double purchaseAmount, int discountAmount) {
        return purchaseAmount;
    }


    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму. Однако, если одно из значений равно 13,
     * то оно не учитывается в сумме. Так, например, если b равно 13, то считается сумма только a и c.
     */
    public int luckySum(int a, int b, int c) {
        int sum = 0;

        int[] input = new int[]{a, b, c};

        for (int i = 0; i < input.length; i++) {
            if (input[i] != 13) {
                sum += input[i];
            }
        }

        return sum;
    }

}