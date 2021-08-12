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


class Result2 {

    /*
     * Complete the 'maxTrailing' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY levels as parameter.
     */

    public static int maxTrailing(List<Integer> levels) {
        int trailingRecord = -1;
        for (int i = 0; i < levels.size(); i++) {
            int currentTrailing;
            for (int j = i - 1; j >= 0; j--)
                if (levels.get(i) > levels.get(j)) {
                    currentTrailing = levels.get(i) - levels.get(j);
                    if (currentTrailing > trailingRecord)
                        trailingRecord = currentTrailing;
                }
        }
        return trailingRecord;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text2.txt"));

        int levelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> levels = IntStream.range(0, levelsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.maxTrailing(levels);

        System.out.println(String.valueOf(result));
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
