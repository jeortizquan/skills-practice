package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'maximumOccurringCharacter' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts STRING text as parameter.
     */

    public static char maximumOccurringCharacter(String text) {
        char charResult = ' ';
        int maxOccur = 0;

        for(int i = 0; i < text.length() - 1; i++) {
            int currentOccur = 0;
            for(int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                   currentOccur++;
                }
            }
            if (currentOccur > maxOccur) {
                maxOccur = currentOccur;
                charResult = text.charAt(i);
            }
        }
        return charResult;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String text = bufferedReader.readLine();

        char result = Result.maximumOccurringCharacter(text);
        System.out.println(result);

        bufferedReader.close();
    }
}

