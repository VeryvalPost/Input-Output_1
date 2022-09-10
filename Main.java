import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] ags) {


        // определяем объект для каталога
        StringBuilder sb = new StringBuilder();

        // создание папок структуры
        File dir = new File("D://games//src");
        if (dir.mkdir()) LogFile(sb, 0, dir.getName());
        File dir1 = new File("D://games//res");
        if (dir1.mkdir()) LogFile(sb, 0, dir1.getName());
        File dir2 = new File("D://games//savegames");
        if (dir2.mkdir()) LogFile(sb, 0, dir2.getName());
        File dir3 = new File("D://games//temp");
        if (dir3.mkdir()) LogFile(sb, 0, dir3.getName());

        // создание папок подкаталогов
        File dirMain = new File("D://games//src", "main");
        if (dirMain.mkdir()) LogFile(sb, 1, dirMain.getName());
        File dirTest = new File("D://games//src", "test");
        if (dirTest.mkdir()) LogFile(sb, 1, dirTest.getName());

        // создание файлов
        File mainJava = new File("D://games//src//main", "Main.java");
        File utilsJava = new File("D://games//src//main", "Utils.java");
        File logFile = new File("D://games//", "temp.txt");
        try {
            if (mainJava.createNewFile()) LogFile(sb, 2, mainJava.getName());
            if (utilsJava.createNewFile()) LogFile(sb, 2, utilsJava.getName());
            if (logFile.createNewFile()) LogFile(sb, 2, logFile.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // создание папок подкаталогов
        File drawRes = new File("D://games//res", "drawables");
        if (drawRes.mkdir()) LogFile(sb, 1, drawRes.getName());
        File vecRes = new File("D://games//res", "vectors");
        if (vecRes.mkdir()) LogFile(sb, 1, vecRes.getName());
        File iconsRes = new File("D://games//res", "icons");
        if (iconsRes.mkdir()) LogFile(sb, 1, iconsRes.getName());

        try {
            FileWriter log = new FileWriter(logFile, false);
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // создание текста лог-файла
    public static StringBuilder LogFile(StringBuilder sb, int index, String name) {
        switch (index) {
            case 0:
                sb
                        .append(" Создан каталог ")
                        .append(name)
                        .append("\n");
                break;
            case 1:
                sb
                        .append(" Создан подкаталог ")
                        .append(name)
                        .append("\n");
                break;
            case 2:
                sb
                        .append(" Создан файл ")
                        .append(name)
                        .append("\n");
                break;
        }
        return sb;
    }
}
