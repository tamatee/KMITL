import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Main3 {
  public static void main(String[] args) {
    try {
      // Create a Scanner object for reading the input
      Scanner scanner = new Scanner(new File("ans.txt"));

      // Create a list to store the integers
      List<Integer> numbers = new ArrayList<>();

      // Read the integers from the file and add them to the list
      while (scanner.hasNextInt()) {
        numbers.add(scanner.nextInt());
      }

      // Sort the list in descending order
      numbers.sort(Collections.reverseOrder());

      // Initialize a variable for the sum
      int sum = 0;

      // Iterate over the first three elements in the list and add them to the sum
      for (int i = 0; i < 3; i++) {
        sum += numbers.get(i);
      }

      // Print the sum
      System.out.println("The sum of the top three numbers is: " + sum);

      // Close the scanner
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
    }
  }
}
