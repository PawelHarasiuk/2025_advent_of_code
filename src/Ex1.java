import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("./src/ex2_input.txt");
            Scanner scanner = new Scanner(inputStream);
            int curr = 50;
            int count = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                char code = line.charAt(0);
                int rotation = Integer.parseInt(line.substring(1));

                while (rotation > 0) {
                    if (code == 'R') curr++;
                    if (code == 'L') curr--;
                    if (curr > 99) curr = 0;
                    if (curr < 0) curr = 99;
                    rotation--;
                }
                if (curr == 0) count++;
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
