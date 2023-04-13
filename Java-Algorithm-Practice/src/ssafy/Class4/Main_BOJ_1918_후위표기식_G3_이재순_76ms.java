package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1918_후위표기식_G3_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder ans = new StringBuilder(); 
		
		postfix(ans, 0, line, line.length());
		System.out.println(ans);
	}
	private static int postfix(StringBuilder ans, int start, String line, int size) {
		Stack<Character> symbol = new Stack<>();
		for (int i = start, end = size-1; i < size; i++) {
			switch (line.charAt(i)) {
			case '(':
				i = postfix(ans, i+1, line, size);
				break;
			case ')':
				while (!symbol.isEmpty()) ans.append(symbol.pop());
				return i;
			case '*':
			case '/':
				if (!symbol.isEmpty()&&(symbol.peek()=='*'||symbol.peek()=='/')) {
					ans.append(symbol.pop());
				}
				symbol.add(line.charAt(i));
				break;
			case '+':
			case '-':
				while (!symbol.isEmpty()) ans.append(symbol.pop());
				symbol.add(line.charAt(i));
				break;

			default:
				ans.append(line.charAt(i));
				break;
			}
			if (i == end) while (!symbol.isEmpty()) ans.append(symbol.pop());
		}
		return 0;
	}
}
