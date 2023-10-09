package ch2;

import java.lang.reflect.Type;

public class StringEx {

    public static void main(String[] args) {
        String name = "Ja" + "va";
        String str = name + 8.0;

        System.out.println(name);
        System.out.println(str);

        System.out.println(":::::::::::::::::::");

        System.out.println(7 + " ");
        System.out.println(" " + 7);
        System.out.println(7 + "");
        System.out.println("" + 7);
        System.out.println("" + "");
        System.out.println(7 + 7 + "");
        System.out.println("" + 7 + 7);

        System.out.println(":::::::::::::::::::");

        String chk1 = "";
        String chk2 = chk1 + 7;
        System.out.println(chk2.getClass().getName());

    }
}
