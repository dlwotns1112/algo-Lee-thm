package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15651_N과M3_00ms {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        go(0, sb, new StringBuilder());
        System.out.println(sb);
    }

    public static void go(int i, StringBuilder sb, StringBuilder temp) {
        if (i == M) {
            sb.append(temp).append("\n");
            return;
        }

        for (int j = 1; j <= N; j++) {
            go(i + 1, sb, new StringBuilder().append(temp).append(j).append(" "));
        }
        return;
    }
}
