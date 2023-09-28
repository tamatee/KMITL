package lab8.lab8b;

import java.util.Arrays;
public class Main {
    private static void m_sort(int[][] data, int pass) {
    }
    private static void m_sort(int[] data, int pass) {
    }
    private static void m_sort(int[][] data, int key1, int key2, int pass) {
    }
    public static void main(String[] args) {
        System.out.println("demo1");
        demo1();
        System.out.println("demo2");
        demo2_descending();
        System.out.println("demo3");
        demo3_multi_key();
    }

    static void demo1() {
        int[] data = { 8, 3, 2, 9, 7, 1, 4 };
        m_sort(data, 0);
        System.out.println(Arrays.toString(data));
    }

    static void demo2_descending() {
        int[][] data = {
                { 11, 88 },
                { 33, 99 },
                { 22, 77 } };
        m_sort(data, 0);
        for (int row = 0; row < data.length; row++)
            System.out.println(Arrays.toString(data[row]));
    }

    static void demo3_multi_key() {
        int[][] data = {
                { 11, 22, 33, 44 },
                { 19, 17, 63, 57 },
                { 17, 22, 18, 15 },
                { 12, 18, 73, 84 },
                { 14, 27, 33, 55 } };

        m_sort(data, 1, 2, 0);
        // expected
        // [14, 27, 33, 55]
        // [11, 22, 33, 44]
        // [17, 22, 18, 15]
        // [12, 18, 73, 84]
        // [19, 17, 63, 57]
        for (int row = 0; row < data.length; row++)
            System.out.println(Arrays.toString(data[row]));
    }
    static void mergeSort(int []input, int pass)
    {
        int size = input.length;
        if (size > 1)
        {
            int mid = size/2;
            int []left = new int[mid];
            int []right = new int[size - mid];
            for (int i = 0; i < mid; i++) {
                left[i] = input[i];
            }

            int size2 = size - mid;
            for (int j = 0; j < size2; j++){
                    right[j] = input[j+mid];
            }

            mergeSort(left, pass);
            mergeSort(right, pass);
            merge(input, left, right);
        }
    }
    static void merge(int []input,int []left, int []right)
    {
        int p = left.length;
        int q = right.length;
        int i = 0, j = 0, k = 0;
        while ((i < p)  && (j < q))
        {
            if (left[i] <= right[j])
            {
                input[k++] = left[i++];
            }
            else
                input[k++] = right[j++];
        }
        if (i == p)
        {
            while (j < q)
            {
                input[k++] = right[j++];
            }
        }
        else {
            while (i < p)
            {
                input[k++] = left[i++];
            }
        }
    }
}