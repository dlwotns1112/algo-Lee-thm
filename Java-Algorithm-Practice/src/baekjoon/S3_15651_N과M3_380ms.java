package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15651_N과M3_380ms {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[M];
        go(0, sb, arr);
        System.out.println(sb);
    }

    public static void go(int i, StringBuilder sb, int[] arr) {
        if (i == M) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 1; j <= N; j++) {
            arr[i] = j;
            go(i + 1, sb, arr);
        }
    }
}
