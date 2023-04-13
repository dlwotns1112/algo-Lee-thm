package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_11057_오르막수_S1_이재순_76ms_DP로안품 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a = 1;
		for (int i = N+9; i > 9; i--) {
			a *= i;
			a %= 10007;
		}
		int b = 1;
		for (int i = 2; i <= N; i++) {
			b *=i;
			b %=10007;
		}
		System.out.println(ferma(a, b));
	}
	private static int ferma(int a, int b) {
		int temp=1;
		int number = 10007;
		int r = number-2;
		while (r!=1) {
			if ((r&1)==1) 
				temp = ((b*temp)%number);
			b = (b*b)%number;
			r>>=1;
		}
		b = (b*temp)%number;
		return (a*b)%number;
	}
}
