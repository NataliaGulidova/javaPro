package Lesson1.Task2;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "C:\\Users\\Admin\\Desktop\\javaPro\\1.txt")
public class TextContainer {
    private String saveString = "string for saving";
    @Saver
    public void save (String path) throws IOException{
        FileWriter fw = new FileWriter(path);
        try {
            fw.write(saveString);
        }finally {
            fw.close();
        }
    }
}
