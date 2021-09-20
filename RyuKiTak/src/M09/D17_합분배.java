package M09;

//https://www.acmicpc.net/problem/2225
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D17_합분배 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] arr = new long[N+1][M+1];
		
		for (int i = 1; i <= M; i++) {
			arr[1][i] = i;
		}
		for (int i = 1; i <= N; i++) {
			arr[i][1] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= M; j++) {
				long temp = arr[i][j-1] + arr[i-1][j];
				
				arr[i][j] = temp % 1000000000;
			}
			
		}
		
//		long answer =  (arr[N][M] % 1000000000);
		// 200 200 (최대) 넣으면 753387060
		System.out.println(arr[N][M]);
	}

}
