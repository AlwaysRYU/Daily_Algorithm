import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_퇴사 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[17];
		int[] P = new int[17];
		int[] dp = new int[17];
		
		for ( int i=1; i <= N; ++i ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for ( int i=1; i <= N+1; ++i ) {
			for ( int j=1; j < i; ++j ) {				
				dp[i] = Math.max(dp[i], dp[j]);				
				if ( j + T[j] == i ) {
					dp[i] = Math.max(dp[i], dp[j] + P[j]);
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
		
	}
}