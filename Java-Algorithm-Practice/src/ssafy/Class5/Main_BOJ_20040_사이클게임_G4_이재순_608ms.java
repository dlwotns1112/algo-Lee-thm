package ssafy.Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20040_사이클게임_G4_이재순_608ms {
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if (unionset(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(0);
	}

	private static int findset(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findset(parents[a]);
	}

	private static boolean unionset(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if (aRoot == bRoot) {
			return true;
		}
		parents[bRoot] = aRoot;
		return false;
	}
}
