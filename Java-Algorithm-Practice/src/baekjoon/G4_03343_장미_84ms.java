package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_03343_장미_84ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());
        if (B * C < A * D) {
            long temp = A;
            A = C;
            C = temp;
            temp = B;
            B = D;
            D = temp;
        }
        long answer = N % C == 0 ? N / C * D : (N / C + 1) * D;
        for (int i = 1; i < C; i++) {
            long tempN = Math.max(N - i * A, 0);
            long tempC = tempN % C == 0 ? tempN / C * D + i * B : (tempN / C + 1) * D + i * B;
            if (tempC < answer) answer = tempC;
        }
        System.out.println(answer);
    }
}