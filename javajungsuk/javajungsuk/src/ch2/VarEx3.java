package ch2;

import javax.sql.rowset.serial.SQLOutputImpl;

public class VarEx3 {
    public static void main(String[] args) {
        int score = 100;
        System.out.println("첫 번째 score 값 : " + score);

        score = 200;
        System.out.println("두 번째 score 값 : " + score);

        final int Max = 100;
//        Max = 200;
        System.out.println(Max);
    }
}
