package baseline;
/*
 * UCF COP 3330 Fall 2021 Assignment 4 Solutions
 * Copyright 2021 Simon Furry
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution45 {
    /*
    Given an input file "exercise45_input.txt":
    read the file and look for all occurrences of the word utilize
    find and replace all occurrences with use
    write the modified file to a new file.

    prompt for a name of the output file,
    write output to a new file.
     */
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        findReplace();
    }
    public static void findReplace(){
        /*
        try-> path.get("exercise44_input.txt")
        .replaceAll("utilize, use")
         */
        System.out.print("What would you like to name the output? ");
        String input = in.next();

        File f1 = new File(input + ".txt"); //generates a .txt file based on user input.


        try{
            Path paths = Paths.get("exercise45_input.txt");
            Files.copy(paths, f1.toPath());
            Path path = Paths.get(input + ".txt"); //copies over the words from the input file to the new user generated file.
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines.map(line -> line.replaceAll("utilize", "use")).collect(Collectors.toList());
            Files.write(path, replaced); //replaces all instances of utilize to use inside the new user generated text file with the copied data
            lines.close();
            System.out.println("Items found and replaced");//confirmation the transfer was successful
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
