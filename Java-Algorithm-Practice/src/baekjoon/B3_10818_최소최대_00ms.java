package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_10818_최소최대_00ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max;
        int min = max = Integer.parseInt(st.nextToken());
        while (--N > 0) {
            int tmp = Integer.parseInt(st.nextToken());
            if (max < tmp) max = tmp;
            else if (min > tmp) min = tmp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }
}
