package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2609
// 20210907 push
public class D01_최대공약수와최소공배수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// 최대 공약수
		int Nanugi = Math.min(A, B);
		while(true) {
			if (A % Nanugi == 0 && B % Nanugi == 0) break;
			Nanugi -= 1;
		}
		
		// 최소 공배수
		int gop = 0;
		if ( A >= B) {
			int g = 1;
			while(true) {
				if ( (A*g) % B == 0) break;
				g += 1;
			}
			gop = A*g;
		} else {
			int g = 1;
			while(true) {
				if ( (B*g) % A == 0) break;
				g += 1;
			}
			gop = B*g;
		}
		System.out.println(Nanugi);
		System.out.println(gop);
	}

}
