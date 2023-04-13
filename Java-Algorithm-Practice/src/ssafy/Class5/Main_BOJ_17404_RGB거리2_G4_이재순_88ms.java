package ssafy.Class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17404_RGB거리2_G4_이재순_88ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][][] arr = new int[3][N][3];// [0][][] = Red, [1][][] = Green, [2][][] = Blue
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0][0][0] = Integer.parseInt(st.nextToken());
		arr[0][0][1] = Integer.parseInt(st.nextToken());
		arr[0][0][2] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		arr[0][1][0] = 2001;
		arr[1][1][1] = 2001;
		arr[2][1][2] = 2001;
		arr[0][1][1] = arr[0][0][0] + b;
		arr[0][1][2] = arr[0][0][0] + c;
		arr[1][1][0] = arr[0][0][1] + a;
		arr[1][1][2] = arr[0][0][1] + c;
		arr[2][1][0] = arr[0][0][2] + a;
		arr[2][1][1] = arr[0][0][2] + b;

		for (int i = 2; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 3; j++) {
				arr[j][i][0] = Math.min(arr[j][i - 1][1], arr[j][i - 1][2]) + red;
				arr[j][i][1] = Math.min(arr[j][i - 1][0], arr[j][i - 1][2]) + green;
				arr[j][i][2] = Math.min(arr[j][i - 1][0], arr[j][i - 1][1]) + blue;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j && ans > arr[i][N - 1][j]) {
					ans = arr[i][N - 1][j];
				}
			}
		}

		System.out.println(ans);
	}
}
