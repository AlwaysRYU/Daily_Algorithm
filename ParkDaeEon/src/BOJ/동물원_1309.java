package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동물원_1309 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 2;
		dp[1][2] = 3;
		
		for (int i = 2; i <= N; i++) {
			// 아무것도 배치 X : i - 1번째에서 배치했을 때의 모든 케이스
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
			// i - 1번째 아무것도 배치 안한 경우 : 양쪽 다 배치 가능
			// i - 1번째 배치한 경우 : i 번째는 하나로 고정
			dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % 9901;
			dp[i][2] = (dp[i][0] + dp[i][1]) % 9901;
		}
		System.out.println(dp[N][2]);
	}

}
