package lab8.lab8b;

import java.util.Arrays;

public class MergeSortTest {
    static int pass = 0;
    public static void main(String []args)
    {
        int []arr = {8, 3, 2, 9, 7, 1, 5, 4};
        int pass = 0;
        MergeSort.mergeSort(arr, pass);
        System.out.println(Arrays.toString(arr) + " pass: " + pass);
    }
}


class MergeSort {
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
        pass+=1;
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
