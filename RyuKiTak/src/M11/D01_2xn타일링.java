package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11726
public class D01_2xn타일링 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		arr[1] = 1; 
		if ( N == 1) {
			System.out.println(1);
			return;
		}
		arr[2] = 2;
		for (int i = 3; i <= N; i++) {
			arr[i] = ( arr[i-2] + arr[i-1] ) % 10_007;
		}
		
		System.out.println( arr[N] % 10_007 );
		
		
	}

}
