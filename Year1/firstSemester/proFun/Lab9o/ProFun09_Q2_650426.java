package proFun.Lab9o;
import java.util.*;
class ProFun09_Q2_650426
{
	public static void main(String[] args)
	{
		int [][] data = { 
			{11, 12, 13, 14},
			{15, 16, 17, 18},
			{19, 20, 21, 22},
			{23, 24, 25, 26},
			{27, 28, 29, 30}
		};
		int [][] hori = flipHorizontal(data);
		for(int row = 0; row < data.length; row++)
		{
			System.out.println(Arrays.toString(hori[row]));
		}
	}
	static int[][] flipHorizontal(int[][] data)
	{
		int[][] aRef = new int[data.length][data[0].length];
		for (int col = 0; col < aRef[0].length; col++) { 
		//	aRef[][col] = data[col][col];
		}
		return aRef;
	}
}
