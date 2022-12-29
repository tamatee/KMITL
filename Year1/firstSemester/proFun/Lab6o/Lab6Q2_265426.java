package proFun.Lab6o;
import java.util.Scanner;
class Lab6Q2_265426 {
    public static void main(String[] args) {
        
        System.out.print("magnet:");
        int [] n = {10,10,10,01,10,10};
        int a,b = 0 , c = 0;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < n.length; i++) {
            a = scan.nextInt();
            if (a != b) {
                c++;
            }
            b=a;
        }
        scan.close();
        System.out.println(c);
    }
}
// import java.util.Scanner;
// class Lab6Q2_265426 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("magnet:");
//         int n = sc.nextInt();
//         int a,b = 0 , c = 0;
//         for (int i = 0; i < n; i++) {
//             a = sc.nextInt();
//             if (a != b) {
//                 c++;
//             }
//             b=a;
//         }
//         System.out.println(c);
//     }
// }