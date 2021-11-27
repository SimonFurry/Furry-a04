import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test46 {
    @Test
    void frequencyCounterTest(){
        Path path = Paths.get("exercise46_input.txt");
        try {
            String text = Files.readString(path);
            text = text.toLowerCase(); //convert all to lowercase to match properly
            Pattern pattern = Pattern.compile("[a-z]+");
            Matcher matcher = pattern.matcher(text);
            TreeMap<String, Integer> freq = new TreeMap<>();
            int frequency = 0;
            while (matcher.find()) {
                String word = matcher.group();
                int letters = word.length();
                if (letters > frequency) {
                    frequency = letters;
                }
                if (freq.containsKey(word)) {
                    freq.computeIfPresent(word, (w, c) -> Integer.valueOf(c.intValue() + 1)); //if word is there, increment to the counter for word
                }
                else {
                    freq.computeIfAbsent(word, (w) -> Integer.valueOf(1));
                }
            }
            String format = "%-" + frequency + "s: %2d%n";
            freq.forEach((k, v) -> System.out.printf(format, k, v));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
