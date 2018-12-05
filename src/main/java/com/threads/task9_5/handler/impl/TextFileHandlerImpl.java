package com.threads.task9_5.handler.impl;

import com.threads.task9_5.handler.TextFileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileHandlerImpl implements TextFileHandler {

    private String path;
    private char character;

    public TextFileHandlerImpl(String path, char character) {
        this.path = path;
        this.character = character;
    }

    public int getWordCount() {
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                Matcher matcher = Pattern.compile(character + "[a-zA-Z-]+").matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return count;
    }
}
