package round0;
// use "Main" for class name. Otherwise, you can't run your code.
import java.util.Scanner; 
public class Main2{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
sc.close();
    output_sum(a);
  }

  static void output_sum(int a)
  {
    int i = 0;
    int mem = 0;
    while (i <= a)
        mem += i++;
    System.out.print(mem);
  }
}