package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_02960_에라토스테네스의체_72ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        int prime = 2;
        int temp = 0;
        while (K-- > 0){
            do{
                temp += prime;
            } while (temp <= N && arr[temp]);
            if (temp > N){
                while (arr[++prime]) {
                }
                temp = prime;
            }
            arr[temp] = true;
        }
        System.out.println(temp);
    }
}
