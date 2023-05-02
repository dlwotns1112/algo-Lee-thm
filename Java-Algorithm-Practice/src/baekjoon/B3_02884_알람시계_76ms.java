package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_02884_알람시계_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		M += 15;
		StringBuilder sb = new StringBuilder();
		if (M > 59)
			sb.append(H).append(" ").append(M - 60);
		else
			sb.append(H == 0 ? 23 : H - 1).append(" ").append(M);
		System.out.println(sb);
    }
}
