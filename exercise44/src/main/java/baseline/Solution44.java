package baseline;
/*
 * UCF COP 3330 Fall 2021 Assignment 4 Solutions
 * Copyright 2021 Simon Furry
 */


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution44 {
    /*
    Create a program that takes a product name as input
   and retrieves the current price and quantity for the product.
   product data is in a data file in the JSON format
   Print out the product name, price, and quantity if the product is found.
   if no product matches the search, state that no product was found and start over (let the suffering continue)
     */
    private String name;
    private double price;
    private int quantity;
    private static final Scanner in = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {
        parseDataSet();
    }

    public static void parseDataSet() throws FileNotFoundException {

        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader("exercise44_input.json"));
            JsonObject obj = gson.fromJson(br, JsonObject.class);
            /*
            Reader reader = Files.newBufferedReader(Paths.get("exercise44_input.json"));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            for(Map.Entry<?, ?> entry : map.entrySet()){
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
             */



            String products = obj.get("products").toString();
            //String name = obj.get("name").toString();

           boolean breakingStatement = true;
            while(breakingStatement == true) {
                System.out.print("What is the product name? ");
                String input = in.next();
                if (input.equals("Widget")) {
                    System.out.print(products);
                    breakingStatement = false;
                } else if (input.equals("Thing")) {
                    System.out.print(products);
                    breakingStatement = false;
                } else if (input.equals("Doodad")) {
                    System.out.print(products);
                    breakingStatement = false;
                } else {
                    System.out.print("Sorry, that product was not found in our inventory.\n");
                    breakingStatement = true;
                }
            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
