package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BlackBoxInt blackBoxInt = null;

        Field innervalue = null;

        try {
            Constructor ctor = BlackBoxInt.class.getDeclaredConstructor();
            ctor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) ctor.newInstance();

            innervalue = BlackBoxInt.class.getDeclaredField("innervalue");
            innervalue.setAccessible(true);

        } catch (NoSuchMethodException
                | InvocationTargetException
                | InstantiationException
                | IllegalAccessException
                | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();


        while (!input.equals("END")) {

            String command = input.substring(0, input.indexOf("_"));
            int value = Integer.parseInt(input.substring(input.indexOf("_") + 1));

            Method method1 = Arrays.stream(methods).filter(method -> method.getName().equals(command))
                    .findFirst()
                    .orElse(null);
            method1.setAccessible(true);
            try {
                method1.invoke(blackBoxInt, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }


            try {
                System.out.println(innervalue.getInt(blackBoxInt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            input = scanner.nextLine();
        }
    }
}
