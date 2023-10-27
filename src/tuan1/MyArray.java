package tuan1;

import java.util.Arrays;

public class MyArray {
	private int[] arr;

	public MyArray(int[] arr) {
		this.arr = arr;
	}

	public int[] mirror() {
		int result[] = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
			result[result.length - i - 1] = arr[i];
		}
		return result;
	}

	public int[] removeDuplicates() {
		int count = 0;
		int n = 1;
		for (int i = 1; i < arr.length; i++) {
			if (chest(i, arr[i], arr) == false) {
				count++;
			}
		}
		int result[] = new int[arr.length - count];
		result[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (chest(n, arr[i], result)) {
				result[n] = arr[i];
				n++;
			}
		}
		return result;
	}

	public boolean chest(int locate, int num, int[] result) {
		boolean b = true;
		for (int i = 0; i < locate; i++) {
			if (num == result[i]) {
				b = false;
			}
		}
		return b;
	}

	public int[] getMissingValue() {
		int n = 0;
		int count=0;
		int[] result = new int[countMissing()];
		for (int i = 1; i < arr.length; i++) {
			count=arr[i]-arr[i-1]-1;
			if(chest2(i)) {
				while(count>0) {
					result[n]=++arr[i-1];
					n++;
					count--;
				}
			
		}
		}
		return result;
	}
	
	public int countMissing() {
		int countMissing = 0;
		for (int i = 1; i < arr.length; i++) {
			if (chest2(i)) {
				countMissing += arr[i] - arr[i - 1] - 1;
			}
		}
		return countMissing;
	}

	public boolean chest2(int locate) {
		boolean b = true;
		for (int i = locate-1; i < locate; i++) {
			if (arr[locate] - arr[i] == 1) {
				b = false;
			}
		}

		return b;
	}
	public boolean chest3(int locate) {
		boolean b = true;
		for (int i = locate-1; i < locate; i++) {
			if (arr[locate]<arr[i]) {
				b = false;
			}
		}
		return b;
	}
	public int[] fillMissingValues(int k) {
		int sum=0;
		int avergerMin=Integer.MAX_VALUE;
		for(int i=1;i<arr.length-k;i++) {
			
			if(!chest3(i)) {
				sum=arr[i-1];
				for(int j=i+1;j<i+k;j++) {
					sum+=arr[j];
				}
				if(sum/k<avergerMin) {
					avergerMin=sum/k;
					
				}
				
				sum=arr[i+1];
				for(int j=i-1;j>i-k;j--) {
					sum+=arr[j];
				}
				
				if(sum/k<avergerMin) {
					avergerMin=sum/k;
					
				}
				arr[i]=avergerMin;
				avergerMin=Integer.MAX_VALUE;
				
			}
			if(arr[0]<0) {
				for(int j=1;j<=k;j++) {
					sum+=arr[j];
				}
				arr[0]=sum/k;
				System.out.println("sum1 "+sum);
				sum=0;
			}
			if(arr[arr.length-1]<0) {
				for(int j=arr.length-1-1;j>=arr.length-k;j--) {
					sum+=arr[j];
				}
				arr[arr.length-1]=sum/k;
				sum=0;
			}
		}
		return arr; 
		}
	
	public static void main(String[] args) {
		int[] arr = { 0,1,1,3,4,5,9 };
		MyArray myarr = new MyArray(arr);
		int result[] = myarr.mirror();
		System.out.println(Arrays.toString(result));

		int result2[] = myarr.removeDuplicates();
		System.out.println(Arrays.toString(result2));
		
		
		myarr = new MyArray(result2);
		int result3[] = myarr.getMissingValue();
		System.out.println(Arrays.toString(result3));
		
		int[]arr3= {-1,11,12,-1,14,10,17,19,-1};
		myarr=new MyArray(arr3);
		System.out.println(Arrays.toString(myarr.fillMissingValues(3)));
	}
}
