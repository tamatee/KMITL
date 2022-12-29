package mergeRun;

import java.util.*;
public class mergeRun {
    public static void main(String[] args) {
        int[] x = {9,7,2,5,6,4,1,7,8,11,22,15,17,14};
        //int[] x = {9,2,1,8,7,3};
        merge(x, 1, x.length);
    }

    public static void merge(int[] x,int p,int q){ 
        if(p >= q){
            return;
        }
        int mid = p+(q-p)/2;

        merge(x, p, mid);
        merge(x, mid+1, q);

        int m = (q-p)/2 + 1;
        int n = m+(q-p)%2-1;

        int[] left = new int[m];
        copy(x,p-1,mid-1,left);
        System.out.println("l " + Arrays.toString(left));

        int[] right = new int[n];
        copy(x,mid,q-1,right);
        System.out.println("r " + Arrays.toString(right));

        int i = 0,j = 0,k = p-1;
        int len1 = left.length;
        int len2 = right.length;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                x[k++] = left[i++];
            } 
            else {
                x[k++] = right[j++];
            }
        }

        while (i < len1) { //Either copy tail of left
            x[k++] = left[i++];
        }

        while (j < len2) { //or copy tail of left
            x[k++] = right[j++];
        }
        
        System.out.println("arr " + Arrays.toString(x));
    }
    static void copy(int[] x,int s,int h,int[] spilt){
        int k = 0;
        for(int i=s;i<=h;i++){
            spilt[k++] = x[i];
        }
    }
}