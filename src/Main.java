import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            System.out.println("Укажите путь");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
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
        }

    }
}

