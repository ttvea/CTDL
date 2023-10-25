package tuan5;

import java.util.Scanner;

public class TicTacToe {
	private static final char EMPTY=' ';
	private char[][]board;
	
	
	public TicTacToe(char[][] board) {
		this.board = board;
	}
	public boolean checkRows() {
		boolean check=false;
		for(int i=0;i<board.length;i++) {
			if(checkArr(board[i])) {
				check=true;
			}
		}
		
		return check; }
	public boolean checkColums() {
		boolean check=false;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(checkArr(getArrayCol(j))) {
					check=true;
				}
			}
			
		}
		return check; }
	public boolean checkDiagonals() {
		char[]duongCheoChinh=new char[board.length];
		char[]duongCheoPhu=new char[board.length];
		for(int i=0;i<board.length;i++) {
			duongCheoChinh[i]=board[i][i];
			duongCheoPhu[i]=board[board.length-i-1][i];
		}
		
		
		return checkArr(duongCheoChinh)||checkArr(duongCheoPhu)?true:false; 
		}
	public  char[] getArrayCol(int indexcol) {
		char arrayCol[] = new char[board.length];
		for (int i = 0; i < arrayCol.length; i++) {
			arrayCol[i] = board[i][indexcol];
		}

		return arrayCol;
	}
	public  boolean checkArr(char []arr) {
		int countX=0;
		int countO=0;
		boolean check=false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==EMPTY) {
				break;
			}else {
				if (Character.compare('X',arr[i])==0) {
					countX++;
				}else {
					countO++;
				}
			}
			if(countX==3) {
				check=true;
				System.out.println("X win");
			}
			if(countO==3) {
				check=true;
				System.out.println("O win");
			}
		}
		return check;
		
		
	}
	public static void print(char[][]arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][]tic={{' ',' ',' '},
					 {' ',' ',' '},
					 {' ',' ',' '}};
		char[][]reset={{' ',' ',' '},
				 	   {' ',' ',' '},
				 	   {' ',' ',' '}};
		TicTacToe game1=new TicTacToe(tic);
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("Nhap indexRow");
			int indexRow=sc.nextInt();
			if(indexRow<0||indexRow>tic.length-1) {
				System.out.println("IndexRow khong hop le");
				break;
			}
			System.out.println("Nhap indexCol");
			int indexCol=sc.nextInt();
			if(indexCol<0||indexCol>tic.length-1) {
				System.out.println("IndexCol khong hop le");
				break;
			}
			System.out.println("Nhap dau");
			String dau=sc.next();
			tic[indexRow][indexCol]=dau.charAt(0);
			game1.checkColums();
			game1.checkRows();
			game1.checkDiagonals();
			print(tic);
			if (game1.checkColums()==true||
			    game1.checkRows()==true||
			    game1.checkDiagonals()==true) {
				tic=reset;
				break;
			}
		}
		}
}

