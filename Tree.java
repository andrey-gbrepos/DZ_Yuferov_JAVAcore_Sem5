import java.io.File;

public class Tree {

      //  print(new File("."), "", true);


    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){

            if (files[i].isDirectory())
            {
                subDirTotal++;

            }
        }
        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {
                print(files[i], indent, subDirTotal == ++subDirCounter);
                if (files[i].length() > 0){
                    File[] files_f = files[i].listFiles();
                    for (int j = 0; j < files_f.length-1; j++) {
                        System.out.println(indent+"│ ├─"+ files_f[j].getName());
                    }
                    System.out.println(indent+"│ └─"+ files_f[files_f.length-1].getName());
                }

            }
        }
    }
}
