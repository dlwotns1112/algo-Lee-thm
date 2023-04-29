package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_01072_게임_80ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = (int)(100L * Y / X);
        if (Z > 98){
            System.out.println(-1);
            return;
        }
        long a = (Z + 1L) * X - 100L * Y;
        a = a % (99 - Z) == 0 ? a / (99 - Z) : a / (99 - Z) + 1;
        System.out.println(a);
    }
}
