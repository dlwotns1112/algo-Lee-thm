package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2133_타일채우기_G5_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N%2 != 0) {
			System.out.println(0);
			return;
		}
		N/=2;
		double root3 = Math.pow(3, 0.5);
		System.out.println(Math.round((pow(2+root3, N)/(3-root3)+pow(2-root3, N)/(3+root3))));
	}
	private static double pow(double a, int b) {
		double temp = 1;
		while (b!=0) {
			if ((b&1)==1) {
				temp *= a; 
			}
			b>>=1;
			a *= a;
		}
		return temp;
	}
}
