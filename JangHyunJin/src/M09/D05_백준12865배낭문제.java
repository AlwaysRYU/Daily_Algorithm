package dynnamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준12865배낭문제 {
	
	
	static int N;
	static int K;
	static int[][]things;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new int[N][2]; 
		dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(buf.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= things[i][0]; j--) {
				dp[j] = Math.max(dp[j], things[i][1] + dp[j-things[i][0]]);
						
			}
			
		}
		System.out.println(dp[K]);
		

	}
}
