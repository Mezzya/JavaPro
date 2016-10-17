package HomeWork1b;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "d:\\file.txt")
public class TextContainer {
    private String text = "Example text";

    public TextContainer() {
    }

    @Save
    public void save(String file) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write(text);
            System.out.println("Сохранение прошло успешно.");
        } catch (IOException e) {
            System.out.println(e);
        }

    }


}
