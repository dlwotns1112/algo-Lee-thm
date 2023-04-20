package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_01913_달팽이_444ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int cur = N * N;
        int[][] arr = new int[N][N];
        int R = N/2;
        for (int i = 0; i < R; i++) {
            int end = N - i - 1;
            for (int j = i; j < end; j++) {
                arr[j][i] = cur--;
            }
            for (int j = i; j < end; j++) {
                arr[end][j] = cur--;
            }
            for (int j = end; j > i; j--) {
                arr[j][end] = cur--;
            }
            for (int j = end; j > i; j--) {
                arr[i][j] = cur--;
            }
        }
        arr[N/2][N/2] = 1;
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if (M == arr[i][j]) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);
    }
}
