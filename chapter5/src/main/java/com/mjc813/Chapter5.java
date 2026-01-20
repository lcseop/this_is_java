package com.mjc813;

public class Chapter5 {
    public void exam() {
        // ------------------- 5-3 예제
        int[] arr1;
        int[] arr2;
        int[] arr3;

        arr1 = new int[] { 1, 2, 3 };
        arr2 = new int[] { 1, 2, 3 };
        arr3 = arr2;

        System.out.println(arr1 == arr2);
        System.out.println(arr2 == arr3);

        // ------------------- 5-4 예제
        int[] intArray = null;
//        intArray[0] = 10;

        String str = null;
//        System.out.println("총 문자 수 : " + str.length());

        // ------------------- 5-5 예제
        String hobby = "여행";
        hobby = null;

        String kind1 = "자동차";
        String kind2 = kind1;
        kind1 = null;
        System.out.println("kind2: " + kind2);

        // ------------------- 5-3 예제
    }
}
