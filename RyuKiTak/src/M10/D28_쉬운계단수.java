package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class D28_쉬운계단수 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// DP 배열생성
		// 
		long[][] DP = new long[100][10];
		
		// 초기 설정
		DP[0][0] = 0;
		for (int i = 1; i < 10; i++) {
			DP[0][i] = 1;
		}

		int N = Integer.parseInt(br.readLine()) -1;
		for (int i = 1; i <= N; i++) {
			DP[i][0] = DP[i-1][1];
			for (int j = 1; j < 9; j++) {
				DP[i][j] = ( DP[i-1][j-1] + DP[i-1][j+1] ) % 1_000_000_000;
			}
			DP[i][9] = DP[i-1][8] % 1_000_000_000;
			
//			System.out.println(Arrays.toString(DP[i]));
		}
		
		
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += DP[N][i];
		}
		System.out.println(answer % 1_000_000_000 );
		
		
		
		
	}

}
