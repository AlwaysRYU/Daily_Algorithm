package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 4트 : 통과함 이게 제일 좋은 코드 같다.
// https://www.acmicpc.net/problem/12920
public class D06_평범한배낭2_4트 {
	static int N, M;
	static int[][] arr;
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물건 종류의 수
		M = Integer.parseInt(st.nextToken()); // 들 수 있는최고의 무게
		
		int[] dp = new int[M+1];
		ArrayList<Integer> weight = new ArrayList<>();
		ArrayList<Integer> satisfaction = new ArrayList<>();
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // 물건의 개수 
			
			int idx = 1;
			while ( K > 0 ) {
				int temp = Math.min(idx, K);
				weight.add(V*temp);
				satisfaction.add(C*temp);
				
				idx *= 2;
				K -= temp;
			}
		}
		
		
		for (int i = 0; i < weight.size(); i++) {
			for (int j = M; j >= 0; j--) {
				System.out.println(j + " weight : " + weight.get(i)  );
				if ( j >= weight.get(i) ) {
					
//					arr[i][j] = Math.max(arr[i][j], arr[i-1][j-weight] + Value);		
					
					dp[j] = Math.max(dp[j], dp[j-weight.get(i)] + satisfaction.get(i));
				}
			}
			System.out.println(Arrays.toString(dp));
			
		}
			
		System.out.println(dp[M]);
		
		
	}

}
