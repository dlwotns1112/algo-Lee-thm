package baekjoon;

import java.io.*;
import java.util.*;

public class B3_02562_최댓값_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int idx = 0;
		for (int i = 1; i < 10; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(answer < cur) {
                answer = cur;
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n").append(idx);
        System.out.println(sb);
    }
}
