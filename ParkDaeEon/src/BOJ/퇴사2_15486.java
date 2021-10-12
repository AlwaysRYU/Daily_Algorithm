package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2_15486 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tArr = new int[N + 2];
		int[] pArr = new int[N + 2];
		int[] dp = new int[N + 2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			tArr[i] = t1;
			pArr[i] = t2;
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N + 1; i++) {
			if (max < dp[i]) max = dp[i];
			int next = i + tArr[i];
			if (next > N + 1) continue;
			dp[next] = Math.max(dp[next], max + pArr[i]);
		}
		System.out.println(dp[N + 1]);
	}
}
