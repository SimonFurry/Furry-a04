import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test43 {
    @Test
    void fileGeneratorTest() throws IOException {
        System.out.print("Site name: ");
        String name = "Dope";
        System.out.print("Author: ");
        String author = "Simon";
        System.out.print("Do you want a folder for JavaScript? ");
        String javaScriptFolder = "y";
        System.out.print("Do you want a folder for CSS? ");
        String cssFolder = "y";

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
