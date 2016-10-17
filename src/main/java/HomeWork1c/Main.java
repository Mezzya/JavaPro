package HomeWork1c;

/**
 * Created by User on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        RefExample rf = new RefExample(10,"Text",11.1,true);
        SerToFile<RefExample> sr = new SerToFile(rf);
        try {
            sr.save(rf);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        try {
            RefExample out = sr.load();
            System.out.println(out);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



    }



}
