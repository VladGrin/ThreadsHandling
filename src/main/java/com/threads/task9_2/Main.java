/*9.2. Напишите консольное приложение, которое:
- описывает поток Counter, задача которого инкрементировать значение некоторой переменной от нуля до 1_000_000;
- описывает поток Printer, задача которого выводить в консоль значение инкрементируемой переменной;
- создает и запускает описанные потоки на исполнение.
ТРЕБОВАНИЯ.
1. Приложение должно быть написано на языке Java.
2. Использовать только стандартные компиляторы и библиотеки.
3. При кодировании должны быть использованы соглашения об оформлении кода для языка Java.
4. Потоки опишите через реализацию интерфейса Runnable с использованием лямбда-выражения.
5. Не используйте синхронизацию и объясните результат работы.
6. Примените механизм wait/notify так, чтобы вывод значения числа был следующим: 0 1 2 3 4 5 6 … 999999.
*/
package com.threads.task9_2;

public class Main {

    private static class CommonResource {
        int count = 0;
    }

    public static void main(String[] args) {

        CommonResource resource = new CommonResource();

        new Thread(() -> {
            Thread.currentThread().setName("Counter");
            System.out.println(Thread.currentThread().getName() + " started");
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (resource) {
                    try {
                        resource.wait();
                        resource.count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("Printer");
            System.out.println(Thread.currentThread().getName() + " started");
            while (resource.count < 1_000_000) {
                try {
                    Thread.sleep(10);
                    synchronized (resource) {
                        System.out.println(resource.count);
                        resource.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("All the threads are started");
    }
}