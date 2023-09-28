package tuan2;

public class Task1_1 {
		// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0 
		public static int getSn1(int n) {
			if(n==0) {
				return 0;
			}else {//getSn1(--n)+n*getSn1Help(n+1,-1)
				return n*getSn1Help(n+1,-1)+getSn1(--n); 
			}//(int) (n*Math.pow(-1,n+1)+ getSn1(--n))
			  }
		public static int getSn1Help(int n,int x) { //tinh luy thua x mu n 
			if(n==0) {
				return 1;
			}else {
				return (x)*getSn1Help(--n,x);
			}
		}
		// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
		public static int getSn2(int n) {
		if(n==0) {
			return 0;//getSn2Help đã tính lun 0! nên lên đây ko tính nữa
		}else {
			return getSn2Help(n--)+getSn2(n--);
		}
		 }
		public static int getSn2Help(int n) {//tinh x!
			if(n==0) {
				return 1;
			}else {
				return n*getSn2Help(--n);
			}
			 }
		// S(n)=1^2+2^2+3^2+....+n^2 , n>0
		public static int getSn3(int n) {
		if(n==0) {
			return 0;
		}else {
			return getSn1Help(2,n)+getSn3(--n);
		}
		 }
		// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
		public static double getSn4(int n) {
			if(n==0) {
				return 1;
			}else {
				return 1/(double)getSn4Help(n--)+getSn4(n--);
			}
		}
		public static int getSn4Help(int n) {
			if(n==0) {
				return 1;
			}else {
				return 2*n*getSn4Help(--n);
			}
		}
		public static void main(String[] args) {
			System.out.println("getSn1 "+getSn1(4));
			
			System.out.println("getSn2 "+getSn2(3));
			
			System.out.println("getSn3 "+getSn3(3));
			
			System.out.println("getSn4 "+getSn4(3));
			
		}
}
