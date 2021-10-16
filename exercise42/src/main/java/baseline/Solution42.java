package baseline;
/*
 * UCF COP 3330 Fall 2021 Assignment 4 Solutions
 * Copyright 2021 Simon Furry
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution42 {
    /*
    Read "exercise42_input.txt"
    process the records and display the results formatted as a table
    evenly spaced
    Last, First, Salary
    String[] splitter = scanner.nextLine().split(",");
    reads data and breaks it at a comma, making a CSV from scratch
     */
    private static final Scanner in = new Scanner(System.in);

    public Solution42() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        fileParser();
    }

    public static void fileParser() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("exercise42_input.txt"));
        FileWriter writer = new FileWriter("exercise42_output.txt");
        Scanner read = new Scanner(br);

        read.useDelimiter(",");

        writer.write("Last\t\tFirst\t\tSalary\n----------------------------------------------\n");

        String lastName, firstName, salary;
        while (read.hasNextLine()) {
            lastName = read.next();
            firstName = read.next();
            salary = read.nextLine();

            writer.write(lastName + "\t\t" + firstName + "\t\t" + salary.replaceAll(",","") + "\n");
            }
        read.close();
        writer.close();
        }

    }
