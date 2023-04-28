package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_01021_회전하는큐_76ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] used = new boolean[N + 1];
        int from = 1;
        int answer = 0;
        for (int t = 0; t < M; t++) {
            int to = Integer.parseInt(st.nextToken());
            int count = 0;
            int count2 = 0;
            for (int i = from; i != to; i++) {
                count2++;
                if (used[i]) count++;
                if (i == N) i = 0;
            }
            used[to] = true;
            answer += Math.min(count2 - count, N - count2 - t + count);
            from = to == N ? 1 : to + 1;
        }
        System.out.println(answer);
    }
}
