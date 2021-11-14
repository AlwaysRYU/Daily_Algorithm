package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1654
public class D12_랜선자르기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] numbers = new int[K];
		long sum = 0;
		for (int i = 0; i < K; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
		}
		long find = 458;
		// 수는 무조건 find이하
		
		// 2-> 작아짐 // 1-> 지난번에 커짐 
		long nextmin = 0;
		long nextmid = 0;
		int total = 0;
		
		while( nextmid < find) {
			
			
			nextmid = (find+nextmin);
			
			total = 0;
			for (int i = 0; i < K; i++) {
				total += (numbers[i] / nextmid);
			}
			System.out.println("이번 계산 : " + total);
			
			if ( total < N) {
				find = nextmid;
			} else {
				nextmin = nextmid +1;
			}
			
			
		}
		
		System.out.println(nextmin);
	}

}
