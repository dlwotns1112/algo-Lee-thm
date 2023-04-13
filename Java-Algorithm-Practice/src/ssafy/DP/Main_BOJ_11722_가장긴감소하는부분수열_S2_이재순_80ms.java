package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11722_가장긴감소하는부분수열_S2_이재순_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];//2진탐색으로 값 저장
		int size = 0;
		
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (arr[size]<cur) {
				arr[++size] = cur;
			} else if(arr[0]>cur) {
				arr[0] = cur;
			} else {
				for (int j = size-1; j >= 0; j--) {
					if (arr[j]<cur) {
						arr[j+1] = cur;
						break;
					}
				}
			}
		}
		System.out.println(size+1);
	}
	private static void binarySearch(int start, int end, int[] arr) {
		
	}
}
