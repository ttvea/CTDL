package Array;



public class Arrayy {
	public static void switchh(int[] arr, int point1, int point2) {
		int change = 0;
		if (point1 >= 0 && point1 < arr.length && point2 >= 0 && point2 < arr.length) {

			change = arr[point1];
			arr[point1] = arr[point2];
			arr[point2] = change;

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");

			}

		}
	}

	public static void detelet(int[] arr, int k) {
		if (k >= 0 && k < arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if (i != k) {
					System.out.print(arr[i] + " ");
				}
			}
		}

	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}

	}

	public static void test(Student st) {
		st.setName("NT");
		st = new Student("NTP", 13);

	}

	public static void test2() {
		Student st = new Student("LVL", 12);
		System.out.println("Ten ban dau: " + st.getName());
		test(st);
		System.out.println("Ten luc sau: " + st.getName());
	}

	public static String thapphan(int n) {
		String kq = "";
		if (n == 0) {
			return kq = "0 ";
		} else {
			if (n == 1) {
				return kq = "1 ";
			}
			else {
				return kq = thapphan(n / 2) + n % 2 + " ";
			}
		}

	}

	public static void main(String[] args) {

		System.out.println(thapphan(15));

//		boolean b=false;
//		boolean c= true;
//		int[]arr= {1,5,7,2,9};
////		switchh(arr, 1, 2);
//		System.out.println();
//		
//		int[]arr2= {1,8,7,5,9};
////		detelet(arr2, 2);
//		
//		if(b^c) {
//			System.out.println("hajds");
//		}

//		int[]arr3= {1,2,3};
//		int[]arr4=arr3;
//		arr3[0]++;
//		System.out.println("arr3[0]= "+arr3[0]);
//		System.out.println("arr4[0]= "+arr4[0]);

	}
}
