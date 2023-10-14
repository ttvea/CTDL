package tuan4;

public class Task1 {
	// sort by descending order
	public static void selectionSort(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length - 1; i++) {// giam bot 1 vong lap
			max = i;
			for (int j = i + 1; j < array.length; j++) {// 3, 5, 6, 8, 9, 2
				if (array[j] > array[max]) {
					max = j;
				}
			}
			swap(array, i, max);
		}
		print(array);
	}

	public static void swap(int[] arr, int index1, int index2) {
		int change = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = change;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void bubbleSort(int[] array) {
		bubbleSortHelp(array, array.length - 1);

		print(array);
	}

	public static void bubbleSortHelp(int[] array, int length) {
		if (length < 0) {
			return;
		} else {
			for (int i = 0; i < length; i++) {
				if (array[i] < array[i + 1]) {
					swap(array, i, i + 1);
				}
			}
			bubbleSortHelp(array, --length);
		}

	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			int j = i;
			while (j > 0 && array[j - 1] < cur) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = cur;
		}
		print(array);

	}

	// sort by descending order
	public static void mergeSort(int[] array) {
		mergeSortHelp(array, 0,array.length-1);
		print(array);
	}

	public static void mergeSortHelp(int[] array, int l, int r) {
		if(l<r) {
			int mid=(l+r)/2;
			mergeSortHelp(array, l, mid);
			mergeSortHelp(array, mid+1, r);
			mergeSortHelp2(array, l, mid, r);
		}
		
	}

	public static void mergeSortHelp2(int[] array, int l, int mid, int r) {
		int n1[] = new int[mid - l + 1];
		int n2[] = new int[r - mid];

		for (int i = 0; i < n1.length; i++) {
			n1[i]=array[l+i];
		}
		for (int j = 0; j < n2.length; j++) {
			n2[j]=array[mid+j+1];//+1 la do đã cho mid vào n1 rồi
		}
		int i=0,j=0,k=l;
		while(i<n1.length&&j<n2.length) {//1 2 3 4 5 6 7 8
			if(n1[i]<n2[j]) {
				array[k]=n2[j];
				j++;
			}else {
				array[k]=n2[i];
				i++;
			}
			k++;
		}
		while(i<n1.length) {
			array[k]=n1[i];
			i++;
			k++;
		}
		while(j<n2.length) {
			array[k]=n2[j];
			j++;
			k++;
		}
	}
	public static void quickSort (int[] array) {
		quickSortHelp(array, 0, array.length-1);
		print(array);
		
	 }
	public static void quickSortHelp(int[] arr, int l, int r) {
        if (l < r) {
            int partitionIndex = getPivot_LastHelp(arr,l,r);
            
            quickSortHelp(arr, l, partitionIndex-1);
            quickSortHelp(arr, partitionIndex+1,r);
        }
    }
	public static int getPivot_LastHelp(int[] array,int l,int r) {
		 // Chọn phần tử cuối cùng làm pivot
        int pivot = array[r];
        // Chỉ số của phần tử nhỏ hơn pivot
        int i = l - 1;
        for (int j = l; j <r; j++) {
            if (array[j] > pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1,r);
        return i + 1;
		
		}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 8, 9, 2 };
		selectionSort(arr);
		System.out.println();
		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
		bubbleSort(arr2);
		System.out.println();
		int[] arr3 = { 1, 2, 3, 4, 5, 6, 7 };
		insertionSort(arr3);
		System.out.println();
		int[] arr4 = { 1, 2, 3, 4, 5, 6 };
		mergeSort(arr4);
		System.out.println();
		int[] arr5 = { 1, 2, 3, 4, 5, 6 };
		quickSort(arr5);
		
		
	}

}
