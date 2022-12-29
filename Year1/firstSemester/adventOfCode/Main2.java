import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
  public static void main(String[] args) {
    String inputFileName = "input.txt"; // replace with the name of your input file
    String outputFileName = "ans.txt"; // replace with the name of your output file
    int sum = 0; // variable to store the sum of the integers
    int max = Integer.MIN_VALUE; // variable to store the maximum integer

    try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
         FileWriter fw = new FileWriter(outputFileName)) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.isEmpty()) { // if the line is empty, write the sum and maximum integer to the output file and reset them to 0 and MIN_VALUE
          fw.write(sum + "\n");
          sum = 0;
          max = Integer.MIN_VALUE;
        } else {
          int value = Integer.parseInt(line);
          sum += value; // add the integer from the line to the sum
          max = Math.max(max, value); // update the maximum value
        }
      }
      fw.write(sum + "\n"); // write the final sum and maximum integer to the output file after the last line
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}