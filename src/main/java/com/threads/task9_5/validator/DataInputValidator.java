package com.threads.task9_5.validator;

import java.util.regex.Pattern;

public class DataInputValidator {

    private static Pattern regexPattern;

    public static boolean inputPathValidator(String path) {
        regexPattern = Pattern.compile("([a-zA-Z]:)?(\\\\[.a-zA-Z0-9_-]+)+", Pattern.UNICODE_CHARACTER_CLASS);
        if (regexPattern.matcher(path).matches()) {
            return true;
        }
        System.out.println("The entered path is incorrect");
        return false;
    }

    public static boolean inputFileNameValidator(String fileName) {
        regexPattern = Pattern.compile("[a-zA-Z0-9_]+.txt", Pattern.UNICODE_CHARACTER_CLASS);
        if (regexPattern.matcher(fileName).matches()) {
            return true;
        }
        System.out.println("The entered file name is incorrect");
        return false;
    }

    public static boolean inputLetterValidator(String letter) {
        regexPattern = Pattern.compile("[a-zA-Z]", Pattern.UNICODE_CHARACTER_CLASS);
        if (regexPattern.matcher(letter).matches()) {
            return true;
        }
        System.out.println("The entered letter is incorrect");
        return false;
    }

    public static boolean inputNumberValidator(String foleName) {
        regexPattern = Pattern.compile("[0-9]", Pattern.UNICODE_CHARACTER_CLASS);
        if (regexPattern.matcher(foleName).matches()) {
            return true;
        }
        System.out.println("The entered number is incorrect");
        return false;
    }
}
