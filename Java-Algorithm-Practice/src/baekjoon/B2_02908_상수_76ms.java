package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_02908_상수_76ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());
        System.out.println(A > B ? A : B);
    }
}
