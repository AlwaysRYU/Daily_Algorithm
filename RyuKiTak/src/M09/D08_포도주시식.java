package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2156
public class D08_포도주시식 {
	static int answer = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N까지의 최대 값 후보
		// 1. N의 값 + N-1의 값 + N-3 까지의 최대값
		// 2. N의 값 + N-2까지의 최대값
		// 그러니까, 앞에 3개는 채워줘야 한다.
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[] max_podoju = new int[N];
		int[] podoju = new int[N];
		for (int i = 0; i < N; i++) {
			podoju[i] = Integer.parseInt(br.readLine());
		}
		
		max_podoju[0] = podoju[0];
		answer = Math.max(answer, max_podoju[0]);
		if( N == 1 ) {
			System.out.println(answer);
			return;
		}
		max_podoju[1] = podoju[0] + podoju[1];
		answer = Math.max(answer, max_podoju[1]);
		if( N == 2 ) {
			System.out.println(answer);
			return;
		}
		
		max_podoju[2] = Math.max(podoju[2] + podoju[1], podoju[2] + podoju[0]);
		max_podoju[2] = Math.max(max_podoju[2], max_podoju[1]);
		answer = Math.max(answer, max_podoju[2]);
		
		// 계산 고고싱
		for (int i = 3; i < N; i++) {
			int candidate_number1 = podoju[i] + podoju[i-1] + max_podoju[i-3];
			int candidate_number2 = podoju[i] + max_podoju[i-2];
			max_podoju[i] = Math.max(candidate_number1, candidate_number2);
			
			max_podoju[i] = Math.max(max_podoju[i], max_podoju[i-1]);
			answer = Math.max(answer, max_podoju[i]);
		}
//		System.out.println(	Arrays.toString(podoju));
//		System.out.println(	Arrays.toString(max_podoju));
		System.out.println(answer);
	}

}
