package BOJ;

import java.util.Scanner;

public class 더하기123_9005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = 0;
		int inputs[] = new int[N];
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			inputs[i] = n;
			max = Math.max(max, n);
		}
		
		int dp[] = new int[max + 1];
		
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		
		for (int i = 4; i <= max; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		
		for (int n : inputs)
			System.out.println(dp[n]);
		sc.close();
	}
}
