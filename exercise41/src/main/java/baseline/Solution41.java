package baseline;
/*
 * UCF COP 3330 Fall 2021 Assignment 4 Solutions
 * Copyright 2021 Simon Furry
 */

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution41 {
    /*
    Organize the contents of a text file alphabetically
    take a list of names from a file named exercise41_input.txt
    count total number of names and organize them alphabetically by last name
     */

    public static void main(String[] args) throws IOException {
        organizeNames();
    }

    public static void organizeNames() throws IOException {
        FileReader fileReader = new FileReader("exercise41_input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> lineCount = new ArrayList<>();

        String line = null;
        while((line = bufferedReader.readLine()) != null){
            lineCount.add(line);
        }
        bufferedReader.close();

            Collections.sort(lineCount, Collator.getInstance());

            FileWriter writer = new FileWriter("exercise41_output.txt");
            writer.write("Total of " + lineCount.size() + " names\n---------------------\n");
            for(String str:lineCount){
                writer.write(str + "\r\n");
            }
            writer.close();
    }
}
