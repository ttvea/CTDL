package tuan10;

import java.util.Arrays;
import java.util.Stack;

import javax.print.attribute.standard.MediaSize.ISO;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> st = new Stack<>();
		for (E e : array) {
			st.push(e);
		}
		while (!st.isEmpty()) {
			for (int i = 0; i < array.length; i++) {
				array[i] = st.pop();
			}
		}
	}

	// This method checks the correctness of the
//	given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>
//	false
	public static boolean isCorrect(String input) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (isOpen(ch)) {
				st.push(ch);
			} else {
				if (isEnd(ch)) {
					if (st.empty() || !check(st.pop(), ch)) { // st.isEmpty nếu chưa có mở ngoặc mà lại có đóng ngoặc
																// thì sai
						return false; // Empty thì sẽ ko pop đc.
					}
				}
			}
		}
		return st.isEmpty();
	}// chỉ thêm dô mở ngoặc, khi có đóng ngoặc thì pop mất cái mở ngoặc==>
		// st.isEmpty đúng.

	public static boolean isOpen(char ch) {
		return ch == '(' || ch == '{' || ch == '[';
	}

	public static boolean isEnd(char ch) {
		return ch == ')' || ch == '}' || ch == ']';
	}

	public static boolean check(char ch1, char ch2) {
		return (ch1 == '(' && ch2 == ')') || (ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']');
	}
	public static boolean check2(char ch) {
		return ch == '+' || ch == '-' || ch == '*'||ch=='/';
	}

	// This method evaluates the value of an
//	expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> so = new Stack<>();
		Stack<Character> phepToan = new Stack<>();
		double result = 0;
		int num1 = 0, num2 = 0;
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
				if(Character.isDigit(ch)) {
					so.push(ch-'0');//char -'0' sẽ trả về số tương ứng
					if(!phepToan.isEmpty()) {
						num2=so.pop();
						num1=so.pop();
						result=(int)tinhToan(phepToan.pop(), num1, num2);
						so.push((int)result);
						
						
					}
				}else
					if (check2(ch)) {
						phepToan.push(ch);
					}
						
				
				
		}
		
		return (int) result;
	}

	public static double tinhToan(char operator, int num1, int num2) {
		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;

		default:
			break;
		}
		return 0;
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3 };
		reserve(arr);
		System.out.println(Arrays.toString(arr));

		String input = "()(())[]{(())}";
		String input2 = "){[]}()";
		System.out.println(isCorrect(input));
		System.out.println(isCorrect(input2));

		String t = "(1+2)*4-3";
		System.out.println(evaluateExpression(t));
	}
}
