package ch2;

import java.sql.Struct;

public class Ex17 {
    public static void main(String[] args) {
        String str = "3";

        System.out.println(str.charAt(0));  // 문자로 변환
        System.out.println(Character.class.isInstance(str.charAt(0)));  // 문자 변환 확인 ok

        System.out.println(str.charAt(0)-'0');  // 숫자로 변환 (문자-0 = 숫자)
        System.out.println(Integer.class.isInstance(str.charAt(0)-'0'));  // 숫자 변환 확인 ok
        System.out.println(Integer.class.isInstance('3'-'0'));            // 숫자 변환 확인 ok
        System.out.println('3'-'0'+1);

        System.out.println(Integer.parseInt("3")+1);    // 숫자로 변환
        System.out.println(Integer.class.isInstance(Integer.parseInt("3")+1));  // 숫자 변환 확인 ok

        System.out.println("3" + 1);    // 문자열로 변환
        System.out.println(String.class.isInstance("3"+1));       // 문자열 변환 확인 ok

        System.out.println(3 + '0');   // '0'은 숫자로 48
        System.out.println(Character.class.isInstance(3+'0'));
        System.out.println(Integer.class.isInstance(3+'0'));    // 문자와 숫자를 더할 수 없으므로 문자가 숫자로 변환되어 결과값 출력
        System.out.println((char)(3 + '0'));    // 문자 '3'으로 변환
        System.out.println((Character.class.isInstance((char)(3+'0'))));    // 문자 변환 확인 ok

    }
}
