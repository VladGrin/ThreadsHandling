package com.threads.task9_5.handler.impl;

import com.threads.task9_5.handler.ResultRecorder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultRecorderImpl implements ResultRecorder {

    @Override
    public synchronized void saveResultToFile(String recordFileName, String path, int result) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(recordFileName, true))) {
            bufferedWriter.write("In the file " + path + " - " + result + " repetitions");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
