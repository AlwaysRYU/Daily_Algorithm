package Combine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준합분해{

	static long arr[][];
	static int N;
	static int K;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[K+1][N+1];

		for (int i = 0; i < K+1; i++) {
			arr[i][0]=1;
		}
		for (int i = 1; i < K+1; i++) {
			for (int j = 1; j < N+1; j++) {
				
				
					arr[i][j]= (arr[i-1][j] + arr[i][j-1])%1000000000;
					
				
			}
		}
		
		
		System.out.println(arr[K][N]);

	}
}
