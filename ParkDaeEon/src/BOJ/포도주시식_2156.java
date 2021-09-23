package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * DP
 */
public class 포도주시식_2156 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];
		if (N >= 2) dp[1] = arr[0] + arr[1];
		for (int i = 2; i < N; i++) {
			if (i == 2) dp[i] = Math.max(dp[0] + arr[2], arr[1] + arr[2]);
			
			dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2]);
			
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}
		System.out.println(dp[N - 1]);
	}

}
