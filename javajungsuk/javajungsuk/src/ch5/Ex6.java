package ch5;

import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {
        int[] iArr = {100, 95, 80, 70, 60};
        System.out.println(iArr);   // 배열을 가리키는 참조변수 iArr값을 출력하면, [I@36baf30c과 같은 문자열이 출력된다.

        // 단, char[]의 경우 참조변수값 출력시 배열 값 출력 가능 -> abcd로 출력
        char[] cArr = {'a', 'b', 'c', 'd'};
        System.out.println(cArr);
        System.out.println();


        // 방법 1. 배열의 요소를 순서대로 하나씩 출력 -> 100 /n 95 /n ...
        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }
        System.out.println();

        // 방법 2. 배열의 모든 요소를 출력 -> [100, 95, 80, 70, 60]
        System.out.println(Arrays.toString(iArr));
        System.out.println(Arrays.toString(cArr));
    }
}
