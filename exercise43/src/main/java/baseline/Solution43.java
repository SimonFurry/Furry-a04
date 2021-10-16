package baseline;
/*
 * UCF COP 3330 Fall 2021 Assignment 4 Solutions
 * Copyright 2021 Simon Furry
 */
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;

public class Solution43 {
    /*
    prompt fo the user for a site name
    prompt for the author of the site
    ask if the user wants a folder for the JavaScript files
    ask if the user wants a folder for CSS files
    generate an index.html fle that contains the name of the site inside the <title> tag and author in a <meta> tag
     */

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        generateWebsiteSkeleton();
    }
    public static void generateWebsiteSkeleton() throws IOException {
        System.out.print("Site name: ");
        String name = in.next().trim();
        System.out.print("Author: ");
        String author = in.next();
        System.out.print("Do you want a folder for JavaScript? ");
        String javaScriptFolder = in.next();
        System.out.print("Do you want a folder for CSS? ");
        String cssFolder = in.next();

       File f1 = new File("website");
       File f2 = new File("website/" + name);
       File f3 = new File("website/" + name + "/index.html");


       f1.mkdir();
       f2.mkdir();
       f3.createNewFile();
       FileWriter fw = new FileWriter(f3);
       fw.write(author);
       fw.flush();
       fw.close();

       System.out.print("\nCreated ./website/" + name + "\n");
       System.out.print("Created ./website/" + name + "/index.html\n");

        if(javaScriptFolder.equals("y") || javaScriptFolder.equals("Y")){
            File f4 = new File("website/" + name + "/js");
            f4.mkdir();
            System.out.print("Created ./website/" + name + "/js/\n");
        }
        if(cssFolder.equals("y") || cssFolder.equals("Y")){
            File f5 = new File("website/" + name + "/css");
            f5.mkdir();
            System.out.print("Created ./website/" + name + "/css/\n");
        }

    }
}
