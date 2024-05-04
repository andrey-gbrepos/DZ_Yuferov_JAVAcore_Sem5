
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

/**
 * Тестовый класс для работы с файлами
 */
public class StendFiles {
    private static final int FILES_COUNT = 8;
    File sourceDir;

    /**
     * Создание каталога
     * @param dirName
     * @return
     */
    public boolean createDir(String dirName){
        sourceDir = new File(dirName);
        if (sourceDir.exists()) sourceDir.delete();
        if (sourceDir.mkdir()){
            return true;
        }
        return false;
    }

    /**
     *Создает FILES_COUNT количество файлов в каталоге dirName
     * @param dirName
     * @throws IOException
     */
    public void createFiles(String dirName) throws IOException {
        if (createDir(dirName)){
            System.out.println("Создан каталог: "+dirName);
            String[] fileNames = new String[FILES_COUNT];
            for (int i = 0; i < fileNames.length; i++) {
                fileNames[i] = "file_" + i + ".txt";
                try (FileOutputStream fileOutputStream = new FileOutputStream(dirName+"/"+fileNames[i])) {
                    fileOutputStream.write(TextGenerator.generateSymbols((i + 1) * (i + 1)).getBytes(StandardCharsets.UTF_8));
                System.out.println("Создан файл: "+ fileNames[i]);
                }
            }
        }
    }

    /**
     * Создает копию каталога с файлами в другом каталоге (backup)
     * @param dir объект исходного каталога -  тип File
     * @param backUpName Имя каталога для копирования - тип String
     * @throws IOException
     */
    public void backUpDir(File dir, String backUpName) throws IOException {
        if (createDir(backUpName)) {
            File[] files = dir.listFiles();
            System.out.println("Копирование в каталог "+backUpName);
            for (int i = 0; i < files.length; i++) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(backUpName + "/" + files[i].getName())) {
                    int c;
                    try (FileInputStream fileInputStream = new FileInputStream(files[i])) {
                        while ((c = fileInputStream.read()) != -1) {
                            fileOutputStream.write(c);
                        }
                        System.out.println("Скопирован файл "+files[i].getName());
                    }
                }
            }
        }
    }
}
