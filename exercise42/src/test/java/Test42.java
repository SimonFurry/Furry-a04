import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test42 {
    @Test
    void parserTest() throws IOException {
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
