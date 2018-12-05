/*9.3. Напишите консольное приложение, которое:
- создает и запускает несколько потоков, которые производят запись в коллекцию типа Map;
- создает и запускает несколько потоков, которые выполняют чтение данных из той же коллекции типа Map;
- опишите коллекцию в двух вариантах:
• типа ConcurrentHashMap;
• типа HashMap;
- оцените время работы потоков с коллекциями.
ТРЕБОВАНИЯ.
1. Приложение должно быть написано на языке Java.
2. Использовать только стандартные компиляторы и библиотеки.
3. При кодировании должны быть использованы соглашения об оформлении кода для языка Java.
4. Потоки опишите через реализацию интерфейса Runnable с использованием лямбда-выражения.
5. Коллекции HashMap и ConcurrentHashMap должны иметь одинаковую начальную емкость и коэффициент загруженности.
6. Количество читающих и записывающих потоков должно быть одинаковым для этих коллекций.
7. Записываемые и читаемые данные должны быть одинаковыми для этих коллекций.
 */

package com.threads.task9_3;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(4, 0.5f);
    private static HashMap<String, String> hashMap = new HashMap<>(4, 0.5f);

    public static void main(String[] args) {

        new WriterToConcurrentHashMap().write(concurrentHashMap);
        new WriterToHashMap().write(hashMap);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new ReaderFromConcurrentHashMap().read(concurrentHashMap);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new ReaderFromHashMap().read(hashMap);
    }
}
