package com.threads.task9_5.handler.impl;

import com.threads.task9_5.handler.TextFileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(bufferedReader.readLine());
                while (matcher.find()) {
                    if(matcher.group().charAt(0) == character){
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return count;
    }
}
