/*9.4. Напишите консольное приложение для вычисления суммы всех элементов массива (из 1_000_000 целых элементов,
значения которых генерируются случайным образом в диапазоне от 0 до 100), используя фреймворк ForkJoin. Для этого:
- создайте и инициализируйте массив размерностью 1_000_000 элементов;
- опишите рекурсивную задачу для деления массива на две части и назначения каждой части другой рекурсивной задаче
для дальнейшего деления;
- продолжайте деление массива, пока в подмассиве не останется менее 20 элементов, и тогда вычислите сумму этих элементов.
ТРЕБОВАНИЯ.
1. Приложение должно быть написано на языке Java.
2. Использовать только стандартные компиляторы и библиотеки.
3. При кодировании должны быть использованы соглашения об оформлении кода для языка Java.
4. Задачу реализуйте как RecursiveTask.
5. Количество рабочих потоков в пуле установите на 8.
 */

package com.threads.task9_4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    private static int amount = 1_000_000;
    private static int[] array = new int[amount];

    public static void main(String[] args) {

        for (int i = 0; i < amount; i++) {
            array[i] = (int) (Math.random() * 101);
        }

        ForkJoinPool pool = new ForkJoinPool(8);
        System.out.println("Result = " + pool.invoke(new Calculator(0, amount - 1)));
    }

    static class Calculator extends RecursiveTask<Long> {

        private int start, end;

        Calculator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if ((end - start) <= 20) {
                long summa = 0L;
                for (int i = start; i <= end; i++) {
                    summa += array[i];
                }
                return summa;
            } else {
                int average = (start + end) / 2;

                Calculator firstHalf = new Calculator(start, average);
                firstHalf.fork();

                Calculator secondHalf = new Calculator(average + 1, end);
                return firstHalf.join() + secondHalf.compute();
            }
        }
    }
}
