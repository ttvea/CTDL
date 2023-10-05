package tuan3;

public class MyArray {
	private int[] arr;

	public MyArray(int[] arr) {
		this.arr = arr;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {

		return recursiveLinearSearchHelp(target, arr.length - 1);
	}

	public int recursiveLinearSearchHelp(int target, int index) {
		if (index < 0) {
			return -1;
		} else {
			if (arr[index] == target) {
				return index;
			}
		}
		return recursiveLinearSearchHelp(target, --index);
	}

	public int iterativeBinarySearch(int target) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			} else {
				if (target > arr[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public int recursiveBinarySearch(int target) {
		
		return recursiveBinarySearchHelp(target, arr.length/2, 0, arr.length-1);
	}
	public int recursiveBinarySearchHelp(int target,int mid,int low, int high) {
		mid=(low+high)/2;
		if(low>high) {
			return -1;
		}else {
			if(target==arr[mid]) {
				return mid;
			}else {
				if(target>arr[mid]) {
					
					return recursiveBinarySearchHelp(target, mid,mid+1, high);
				}else {
					
					return recursiveBinarySearchHelp(target, mid,low,mid-1);
				}
			}
		}
		
		
		}
	//array giam dan
	public int iterativeBinarySearch2(int target) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			} else {
				if (target > arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 3, 4, 2, 11, 4 };
		MyArray myarr = new MyArray(arr);
		System.out.println("iterativeLinearSearch " + myarr.iterativeLinearSearch(4));

		System.out.println("recursiveLinearSearch " + myarr.recursiveLinearSearch(4));

		int arr2[] = { 1, 3, 4, 5, 6, 8,11, 13 };
		myarr = new MyArray(arr2);
		System.out.println("iterativeBinarySearch " + myarr.iterativeBinarySearch(1));
		System.out.println("recursiveBinarySearch "+myarr.recursiveBinarySearch(4));
		
		int[]arr3= {9,8,6,4,2,1};
		myarr=new MyArray(arr3);
		System.out.println("iterativeBinarySearch2 "+myarr.iterativeBinarySearch2(4));
	}
}
