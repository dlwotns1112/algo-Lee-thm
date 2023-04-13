package ssafy.Class5;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main_BOJ_12850_본대산책2_G1_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());

		long[][] map = {{ 0, 1, 1, 0, 0, 0, 0, 0 },
						{ 1, 0, 1, 1, 0, 0, 0, 0 },
						{ 1, 1, 0, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 1, 0, 0 },
						{ 0, 0, 1, 1, 0, 1, 1, 0 },
						{ 0, 0, 0, 1, 1, 0, 0, 1 },
						{ 0, 0, 0, 0, 1, 0, 0, 1 },
						{ 0, 0, 0, 0, 0, 1, 1, 0 }};
		
		long[][] temp = {{ 1, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 1, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 1, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 1, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 1, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1 }};
		
		while (D>1) {
			if ((D&1)==1) {
				temp = mul(temp, map);
			}
			map = mul(map, map);
			D>>=1;
		}
		map = mul(map, temp);
		
		System.out.println(map[0][0]);
	}
	
	private static long[][] mul(long[][] a, long[][] b) {
		long[][] result = new long[8][8];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				for (int k = 0; k < result.length; k++) {
					result[i][j] += a[i][k]*b[k][j];
				}
				result[i][j] %= 1000000007;
			}
		}
		return result;
	}
}
