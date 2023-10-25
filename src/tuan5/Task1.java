package tuan5;

import java.util.Arrays;

public class Task1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Hai ma trận không cùng cỡ, không cộng được");
			return null;
		} else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					result[i][j] = a[i][j] + b[i][j];
				}
			}
		}
		return result;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Hai ma trận không cùng cỡ, không trừ được");
			return null;
		} else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					result[i][j] = a[i][j] - b[i][j];
				}
			}
		}
		return result;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		if(a.length!=b[0].length){
			return null;
		}
		int result[][] = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				result[i][j] = multiply1D_Array(a[i],getArrayCol(b, j));
			}
		}
		return result;
	}

	public static int[] getArrayCol(int[][] arr, int indexcol) {
		int arrayCol[] = new int[arr.length];
		for (int i = 0; i < arrayCol.length; i++) {
			arrayCol[i] = arr[i][indexcol];
		}

		return arrayCol;
	}

	public static int multiply1D_Array(int[] col, int[] row) {
		int sum = 0;
		for (int i = 0; i < col.length; i++) {
			sum += col[i] * row[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 3, 4, 5 } };
		int arr2[][] = { { 1, 2, 3 }, { 3, 4, 5 } };
		System.out.println(Arrays.deepToString(add(arr, arr2)));
		System.out.println(Arrays.deepToString(subtract(arr, arr2)));
		int arr3[][] = { { 1, 2, 3 },
						 { 3, 4, 5 } };
		int arr4[][] = { { 1, 2 }, 
						 { 3, 4 },
						 { 5, 6 } };
		System.out.println(Arrays.deepToString(multiply(arr3, arr4)));
		System.out.println(Arrays.toString(getArrayCol(arr4, 0)));
	}
}
