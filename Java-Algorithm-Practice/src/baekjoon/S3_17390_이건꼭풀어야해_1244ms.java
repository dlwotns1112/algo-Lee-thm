package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_17390_이건꼭풀어야해_1244ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 2; i <= N; i++) {
            arr[i] += arr[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(-arr[Integer.parseInt(st.nextToken()) - 1] + arr[Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.println(sb);
    }
}
