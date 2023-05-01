package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15657_N과M8_108ms {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        go(0, sb, new int[M], 0);
        System.out.print(sb);
    }

    public static void go(int i, StringBuilder sb, int[] used, int k) {
        if (i == M) {
            for (int j = 0; j < M; j++) {
                sb.append(used[j]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = k; j < N; j++) {
            used[i] = arr[j];
            go(i + 1, sb, used, j);
        }
    }
}
