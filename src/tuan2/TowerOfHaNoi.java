package tuan2;

public class TowerOfHaNoi {
	public static String moveDisk(int disk,String soure, String dest,String spare ) {
		if(disk==0) {
			
			return "move disk from "+soure+ " to "+dest;
		}else {
			return moveDisk(disk-1, soure,spare , dest)+"\n"+
					"move disk from "+soure+ " to "+dest+"\n"+
					moveDisk(disk-1,spare, dest, soure);
			
		}
	}
	public static void main(String[] args) {
		System.out.println(moveDisk(6,"thap 1", "thap 2","thap 3"));
	}
}
