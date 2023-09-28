package tuan2;

import java.util.Arrays;

public class PascalTriangle {
	public static void printPascalTriangle(int row) {
		if(row==0) {
			return;
		}
		int result[]=getPascalTriangle(row);
		printPascalTriangle(--row);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };// mang co 1 pt la 1
		} else {
			return generateNextRow(getPascalTriangle(--n));
		}
	}
	//
	public static int[] generateNextRow(int[] prevRow) {
		int result[] = new int[prevRow.length + 1];
		result[0] = 1;
		result[result.length-1] = 1;
		for (int i = 1; i < result.length-1; i++) {
			result[i] = prevRow[i] +  prevRow[i - 1];
		}
		return result;
	}
	public static void main(String[] args) {
		printPascalTriangle(5);
		int arr[]= {1,2,1};
		System.out.print(Arrays.toString(generateNextRow(arr)));
	}
}
