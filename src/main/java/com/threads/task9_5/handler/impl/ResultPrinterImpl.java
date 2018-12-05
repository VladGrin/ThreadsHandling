package com.threads.task9_5.handler.impl;

import com.threads.task9_5.handler.ResultPrinter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResultPrinterImpl implements ResultPrinter {

    @Override
    public void printResultFromFile(String recordFileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(recordFileName)))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
