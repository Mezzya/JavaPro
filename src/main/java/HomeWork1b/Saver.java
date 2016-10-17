package HomeWork1b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer();
        Class<?> cl = textContainer.getClass();

        if (!cl.isAnnotationPresent(SaveTo.class)) {
            throw new IllegalArgumentException("Нет нашей аннотации SateTo");
        }

        SaveTo sTo = cl.getAnnotation(SaveTo.class);

//      Нашли параметр
        String fileToSave = sTo.path();

        Method[] methods = cl.getDeclaredMethods();

        for (Method mt : methods) {


            if (mt.isAnnotationPresent(Save.class)) {
//              Нашли нужный метод

                try {
//                  Запустили с найденным параметром
                    mt.invoke(textContainer, fileToSave);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }


        }


    }
}
