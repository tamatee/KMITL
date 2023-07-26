package comSci.Lab4;

public class Lab4 {
    public static void main(String[] args) {
    int [] arr = { 1, 2, 1, 4, 2, 2, 5, 7 };
    int maxCnt = 0;
    int cnt;
    int k = 0;
    int ans = 0;
    int secret = 0;
    int m = 0;
    int arrSize = arr.length; // arrSize is 8
    for (int i = 0; i < arrSize; i++) {
    cnt = 0;
    for (int j = 0; j < arrSize; j++) {
    if (arr[i] == arr[j]) {
    cnt++;
    k++;
     } // if
     } // j
     if (cnt > maxCnt) {
     maxCnt = cnt;
     ans = arr[i];
     secret = i;    
     m++;   
     } // if
     }
     System.out.println("ans: "+ ans + " maxCnt: " + maxCnt);
     secret += k + m;
     System.out.println("Secret: " + secret);
     System.out.println("ans :"+ans);
     System.out.println("m: "+ m);
    }
}
