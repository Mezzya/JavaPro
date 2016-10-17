package HomeWork1c;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by User on 18.10.2016.
 */
public class SerToFile<T> {
    private T ob;

    public SerToFile(T ob) {
        this.ob = ob;
    }

    public void save(T obj) throws IllegalAccessException {


        Class<?> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\ser.txt"))) {

            for (Field field : fields) {

                if (field.isAnnotationPresent(Save.class)) {

                    if (!field.isAccessible()) field.setAccessible(true);

                    bw.write("" + field.get(obj));
                    bw.newLine();

                }

            }


        } catch (IOException e) {
            System.out.println(e);
        }


    }

    public T load() throws IllegalAccessException {

        Class cl = ob.getClass();
        Field[] fields = cl.getDeclaredFields();

        try (BufferedReader br = new BufferedReader(new FileReader("d:\\ser.txt"))) {

            for (Field field : fields) {

                if (field.isAnnotationPresent(Save.class)) {
                    String str = br.readLine();
                    if (br == null) throw new IllegalArgumentException("Файл данных поврежден");

                    if (!field.isAccessible()) field.setAccessible(true);

                    if (field.getType() == int.class) {
                        field.setInt(ob, Integer.parseInt(str));
                    }

                    if (field.getType() == String.class) {
                        field.set(ob, (String) str);
                    }

                    if (field.getType() == Boolean.class) {
                        field.setBoolean(ob, str.equals("true") ? true : false); // Ого написал ))
                    }

                    if (field.getType() == Double.class){
                        field.setDouble(ob, Double.parseDouble(str));
                    }

                }

            }


        } catch (IOException e) {
            System.out.println(e);
        }


        return ob;
    }


}
