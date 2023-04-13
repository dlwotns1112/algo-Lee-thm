package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15651_N과M3_336ms {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        System.out.println(go(0, sb, temp));
    }

    public static StringBuilder go(int i, StringBuilder sb, StringBuilder temp) {
        if (i == M) {
            return sb.append(temp).append("\n");
        }

        for (int j = 1; j <= N; j++) {
            temp.append(j).append(" ");
            go(i + 1, sb, temp);
            temp.delete(temp.length()-2, temp.length());
        }
        return sb;
    }
}
