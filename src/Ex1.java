import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int curr = 50;
        int count = 0;

        try {
            InputStream inputStream = new FileInputStream("./src/ex1_input.txt");
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                char rotation = line.charAt(0);
                int value = Integer.parseInt(line.substring(1)) % 100;

                if (rotation == 'R') {
                    curr += value;
                }
                if (rotation == 'L') {
                    curr -= value;
                }

                if (curr > 99) curr = curr - 100;
                if (curr < 0) curr = curr + 100;
                if (curr == 0) count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }
}
