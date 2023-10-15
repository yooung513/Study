package ch2;

public class VarEx5 {
    public static void main(String[] args) {
        char ch = 'A';
        System.out.println(ch);

        int i = 'A';
        System.out.println(i);

//        char ch_e1 = 'AB';  // 에러 -> 문자열 불가
//        char ch_e2 = '';    // 에러 -> 빈 문자 불가

        String str1 = "";    // 빈 문자열 가능
        String str2 = "A";   // 하나의 문자열 가능
        String str3 = "ABCD";

        String str4 = str2+str3;    // 문자열끼리의 덧셈
        String str5 = str2+i;       // 문자열+숫자 -> 문자열

        System.out.println(str4);
        System.out.println(str5);

        System.out.println(Integer.class.isInstance(i));            // int 타입으로 출력
        System.out.println(Integer.class.isInstance(i+""));     // String 타입으로 출력 (숫자+"")

        System.out.println(""+7+7);
        System.out.println(7+7+"");


    }
}
