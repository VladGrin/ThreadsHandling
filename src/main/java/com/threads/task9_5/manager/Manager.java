package com.threads.task9_5.manager;

import com.threads.task9_5.handler.ResultPrinter;
import com.threads.task9_5.handler.ResultRecorder;
import com.threads.task9_5.handler.TextFileHandler;
import com.threads.task9_5.handler.impl.PathHandlerImpl;
import com.threads.task9_5.handler.impl.ResultPrinterImpl;
import com.threads.task9_5.handler.impl.ResultRecorderImpl;
import com.threads.task9_5.handler.impl.TextFileHandlerImpl;
import com.threads.task9_5.validator.DataInputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    private Scanner scanner = new Scanner(System.in);
    private List<String> paths = new ArrayList<>();

    public void run() {
        boolean isDone = true;
        while (isDone) {
            String directoryPath;
            String recordFileName;
            String letter;
            String choiceNumber;
            do {
                System.out.println("Enter the name and location of the directory in the format C:\\directory\\subdirectory...");
                directoryPath = scanner.nextLine();
            } while (!DataInputValidator.inputPathValidator(directoryPath));
            do {
                System.out.println("Enter the name of the file to write.");
                recordFileName = scanner.nextLine() + ".txt";
            } while (!DataInputValidator.inputFileNameValidator(recordFileName));
            do {
                System.out.println("Enter the letter.");
                letter = scanner.nextLine();
            } while (!DataInputValidator.inputLetterValidator(letter));

            List<String> allPaths = new PathHandlerImpl(paths, directoryPath).findAllPaths();

            for (String path : allPaths) {
                String finalRecordFileName = recordFileName;
                String finalLetter = letter;
                new Thread(() -> {
                    TextFileHandler textFileHandler = new TextFileHandlerImpl(path, finalLetter.charAt(0));
                    int wordCount = textFileHandler.getWordCount();
                    ResultRecorder resultRecorder = new ResultRecorderImpl();
                    resultRecorder.saveResultToFile(finalRecordFileName, path, wordCount);
                }).start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ResultPrinter resultPrinter = new ResultPrinterImpl();
            resultPrinter.printResultFromFile(recordFileName);

            do {
                System.out.println("\nIf you want to enter press 1");
                choiceNumber = scanner.nextLine();
            } while (!DataInputValidator.inputNumberValidator(choiceNumber));
            if (Integer.parseInt(choiceNumber) == 1) {
                isDone = false;
            }
        }
    }
}
