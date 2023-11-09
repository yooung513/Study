package ch5;

import java.util.Arrays;

public class Ex24 {
    public static void main(String[] args) {
        String[][] str2D_1 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D_2 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D_3 = new String[][]{{"AAA", "BBB"}, {"aaa", "bbb"}};

        System.out.println(str2D_1 == str2D_2);     // 참조변수 값 비교 (false)
        System.out.println(Arrays.equals(str2D_1, str2D_2));
        System.out.println(Arrays.deepEquals(str2D_1, str2D_2));
        System.out.println(Arrays.deepEquals(str2D_2, str2D_3));
        System.out.println();


        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {{11, 22}, {21, 22}};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2D));
        System.out.println(Arrays.deepToString(arr2D));
        System.out.println();


        int[] arrCopy_1 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy_2 = Arrays.copyOf(arr, 3);
        int[] arrCopy_3 = Arrays.copyOf(arr, 7);
        int[] arrCopy_4 = Arrays.copyOfRange(arr, 2, 4);
        int[] arrCopy_5 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println(Arrays.toString(arrCopy_1));
        System.out.println(Arrays.toString(arrCopy_2));
        System.out.println(Arrays.toString(arrCopy_3));
        System.out.println(Arrays.toString(arrCopy_4));
        System.out.println(Arrays.toString(arrCopy_5));
        System.out.println();


        int[] iArr = {3, 2, 0, 1, 4};
        Arrays.sort(iArr);
        System.out.println(Arrays.toString(iArr));
    }
}
