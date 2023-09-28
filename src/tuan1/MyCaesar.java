package tuan1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int n) {
		this.n = n;
	}
	public char encryptChar(char c) {
		int index = 0;
		if(Character.isLetter(c)) {
			c=Character.toUpperCase(c);
			for(int i=0;i<ALPHABET.length;i++) { //dùng for each lại lỗi?
				if(c==ALPHABET[i]) {
					index=i;
					break;//tìm thấy rồi thì dừng, ko tìm nữa.
				}
			}
			
			return ALPHABET[(n+index)%26];
		}
		return c;
		}
	public String encrypt(String input) {
		String result="";
		for(int i=0;i<input.length();i++) {
			result+=encryptChar(input.charAt(i));
		}
		
		return result; 
		}
	public char decryptChar(char c) {
		int index = 0;
		if(Character.isLetter(c)) {
			
			for(int i=0;i<ALPHABET.length;i++) { 
				if(c==ALPHABET[i]) {
					index=i;
					break;
				}
			}
			if(index-n>=0) {
				return ALPHABET[(index-n)%26];
			}else {
				return ALPHABET[(index-n)%26+26];
			}
			
		}
		return c;
		
		}
	
	public String decryptString(String input) {
		String result="";
		for(int i=0;i<input.length();i++) {
			result+=decryptChar(input.charAt(i));
		}
		return result; 
		}
	public static void main(String[] args) {
		MyCaesar mycaesar= new MyCaesar(1);
		System.out.println(mycaesar.encryptChar('z'));
		System.out.println(mycaesar.decryptChar(mycaesar.encryptChar('z')));
		
		
		System.out.println(mycaesar.encrypt("Za!"));
		System.out.println(mycaesar.decryptString(mycaesar.encrypt("Za!")));
		
		
	}
}

