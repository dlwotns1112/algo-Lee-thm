package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_17266_어두운굴다리_212ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int max = p1 * 2;
        for (int i = 1; i < M; i++ ){
            int p2 = Integer.parseInt(st.nextToken());
            if (p2 - p1 > max){
                max = p2 - p1;
            }
            p1 = p2;
        }
        if ((N - p1) * 2 > max){
            max = (N - p1) * 2;
        }
        System.out.println(max%2==1?max/2+1:max/2);
    }
}
