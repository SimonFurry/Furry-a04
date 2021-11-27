import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test41 {
    @Test
    void organizeTest() throws IOException {
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
