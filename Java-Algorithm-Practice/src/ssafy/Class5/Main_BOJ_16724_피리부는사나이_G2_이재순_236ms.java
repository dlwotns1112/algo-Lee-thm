package ssafy.Class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16724_피리부는사나이_G2_이재순_236ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] parents = new int[N*M];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (line.charAt(j)) {
				case 'D':
					if (unionset(i*M+j, i*M+j+M, parents)) {
						ans++;
					}
					break;
				case 'U':
					if (unionset(i*M+j, i*M+j-M, parents)) {
						ans++;
					}
					break;
				case 'L':
					if (unionset(i*M+j, i*M+j-1, parents)) {
						ans++;
					}
					break;
				case 'R':
					if (unionset(i*M+j, i*M+j+1, parents)) {
						ans++;
					}
					break;
				}
			}
		}
		System.out.println(ans);
	}
	private static int findset(int a, int[] parents) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findset(parents[a], parents);
	}

	private static boolean unionset(int a, int b, int[] parents) {
		int aRoot = findset(a, parents);
		int bRoot = findset(b, parents);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return false;
		}
		return true;
	}
	
}
