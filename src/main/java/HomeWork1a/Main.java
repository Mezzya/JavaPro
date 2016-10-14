package HomeWork1a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by User on 15.10.2016.
 */

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface  Test{
    int a();
    int b();

}
public class Main {
    @Test(a=2,b=3)
    public void test(int a,int b)
    {
        System.out.println("A="+a+" B="+b);
    }


    public static void main(String[] args) {

        Main first = new Main();

        Class<Main> cc = Main.class;

        Method[] method = cc.getMethods();

        for ( Method mm : method) {

            if (mm.isAnnotationPresent(Test.class))
            {
                Test tt = mm.getDeclaredAnnotation(Test.class);
                int a = tt.a();
                int b = tt.b();
//                Запускаем

                first.test(a,b);


            }

        }


    }

}
