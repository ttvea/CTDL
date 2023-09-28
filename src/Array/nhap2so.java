package Array;

public class nhap2so {
	
	public static int sum(int n) {
		int s=1;
		for(int i=1;i<=n;i++) {
			s+=1/2*n;
		}
		return s+sum(n*2);
	}
	public static void main(String[] args) {
		
		System.out.println(sum(2));
	}
}
