import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test45 {
    @Test
    void findReplaceTest(){
                /*
        try-> path.get("exercise44_input.txt")
        .replaceAll("utilize, use")
         */
        System.out.print("What would you like to name the output? ");
        String input = "bababooey";

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
