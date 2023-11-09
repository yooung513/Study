package ch5;

public class Ex14 {
    public static void main(String[] args) {
        String str = "ABCDE";

        char ch = str.charAt(2);
        System.out.println(ch);

        String subStr_1 = str.substring(1, 4);
        String subStr_2 = str.substring(1);
        System.out.println(subStr_1);
        System.out.println(subStr_2);

        int len = str.length();
        System.out.println(len);

        System.out.println(str.equals("abcde"));
        System.out.println(str.equals("ABCDE"));

        System.out.println(str.toCharArray());
    }
}
