package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_10994_별찍기19_132ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int half = 2 * n - 1;
        n = 4 * (n - 1) + 1;
        StringBuilder sb = new StringBuilder();
        boolean bit;
        for (int i = 0; i < half; i++) {
            bit = false;
            for (int j = 0; j <= i; j++) {
                bit = !bit;
                if (bit) sb.append("*");
                else sb.append(" ");
            }
            go(i + 1, n, n - i, bit, sb);
            sb.append("\n");
        }
        for (int i = half; i < n; i++) {
            bit = false;
            for (int j = 0; j < n - i; j++) {
                bit = !bit;
                if (bit) sb.append("*");
                else sb.append(" ");
            }
            go(n - i, n, i + 1, bit, sb);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void go(int start, int n, int temp, boolean bit, StringBuilder sb) {
        for (int j = start; j < temp; j++) {
            if (bit) sb.append("*");
            else sb.append(" ");
        }
        for (int j = temp; j < n; j++) {
            bit = !bit;
            if (bit) sb.append("*");
            else sb.append(" ");
        }
    }
}
