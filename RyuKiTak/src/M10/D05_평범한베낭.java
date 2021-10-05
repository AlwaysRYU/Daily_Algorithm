package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12865
public class D05_평범한베낭 {
	static int N, K;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int Value = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= K; j++) {
					arr[i][j] = Math.max(arr[i][j], arr[i-1][j]);
				if ((j-weight) >= 0 ) {
					arr[i][j] = Math.max(arr[i][j], arr[i-1][j-weight] + Value);					
				}
			}
		}
		
//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		System.out.println(arr[N][K]);
		
	}

}
