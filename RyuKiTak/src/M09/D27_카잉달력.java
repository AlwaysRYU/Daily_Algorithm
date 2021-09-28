package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/6064
public class D27_카잉달력 {
	static int M,N,x,y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Test = Integer.parseInt(br.readLine());
		for (int i = 1; i <= Test; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			// 마지막 년도 구하기 
			int last = GCD(M,N);
//			System.out.println(last);
			int answer = -1;
			int x1, x2 = x1 = 1;
			int count = 1;
			while(true) {
//				System.out.println(x1 + " : "+ x2);
				
				if (x1 == x && x2 == y) {
					answer = count;
					break;
				}
				
				x1 += 1;
				if (x1 > M) x1 = 1;
				x2 += 1;
				if (x2 > N) x2 = 1;
				count += 1;
				if (count > last) break;				
			}
			
			if (answer == -1) {
				System.out.println(-1);
			} else {
				System.out.println(count);
			}
			
		}
	}
	
	static int GCD(int M, int N ) {
		int big, small;
		if ( M>= N) {
			big = M;
			small = N;
		} else {
			big = N;
			small = M;
		}
		
		int R = 0;
		int x = 1;
		while(true) {
			if ( (big * x) % small == 0 ) {
				R = big*x;
				break;
			}
			x += 1;
		}
		return R;
	}
}
