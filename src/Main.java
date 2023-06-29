import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 1;
        boolean fileExists;
        boolean isDirectory;
        while (true) {
            System.out.println("Укажите путь");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            fileExists = file.exists();
            isDirectory = file.isDirectory();
            if (!fileExists) {
                System.out.println("Указанный файл не существует");
                continue;
            };
            if (isDirectory) {
                System.out.println("Указанный путь является путём к папке, а не к файлу");
                continue;
            };
            System.out.println("Путь указан верно; Это файл номер " + i);
            i++;
            try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int j = 0;
            int max = 0, min = 2147483647;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                if (length > 1024) {
                    throw new RuntimeException ("Длина строки более 1024 символов");
                };
                if (length > max) {
                    max = length;
                };
                if (length < min) {
                    min = length;
                }
                j++;
            }
                System.out.println("Общее кол-во строк в файле: " + j);
                System.out.println("Длина самой длинной строки в файле: " + max);
                System.out.println("Длина самой короткой строки в файле: " + min);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
