import java.io.File;
import java.io.IOException;

public class Program {

    public  static void main(String[] args){

        StendFiles stendFiles = new StendFiles();
        String sourceDirName = "myDirectory";
        String backupDirName = "backup";
        /**
        * Создание каталога с файлами и их заполнение
        */
        try {
            stendFiles.createFiles(sourceDirName);
        } catch (IOException e){
            System.out.println(e);
        }
        /**
         * Создание резервного каталога
         */
        File directory = new File(sourceDirName);
        try{
            stendFiles.backUpDir(directory,backupDirName);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
