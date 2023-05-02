package baekjoon;

import java.io.*;

public class B4_02742_기찍N_164ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) + 1;
		StringBuilder sb = new StringBuilder();
        while (N-- > 1) {
            sb.append(N).append("\n");
        }
		System.out.print(sb);
    }
}
