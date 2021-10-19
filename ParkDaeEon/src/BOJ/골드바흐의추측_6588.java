package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드바흐의추측_6588 {
	static boolean[] notPrime = new boolean[1000001];
	public static void main(String[] args) throws Exception {
		for (int i = 2; i * i <= 1000000; i++) {
			for (int j = i * i; j <= 1000000; j += i) {
				notPrime[j] = true;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			
			int i = 2;
			int j = N - 2;
			
			while (true) {
				if (i % 2 == 1 && j % 2 == 1 && !notPrime[i] && !notPrime[j]) {
					System.out.println(N + " = " + i + " + " + j);
					break;
				}
				if (i == j) {
					System.out.println("Goldbach's conjecture is wrong.");
					break;
				}
				i++;
				j--;
			}
		}
		
	}
}
