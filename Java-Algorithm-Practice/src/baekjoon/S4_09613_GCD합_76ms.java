package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_09613_GCD합_76ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            long answer = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                for (int j = i - 1; j >=  0; j--) {
                    answer += GCD(arr[i], arr[j]);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static int GCD(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int r = 0;
        while (true){
            r = a % b;
            if (r == 0) return b;
            a = b;
            b = r;
        }
    }
}
