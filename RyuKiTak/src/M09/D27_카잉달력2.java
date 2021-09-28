package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/6064
public class D27_카잉달력2 {
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
			int last = least(M,N);
			int temp = x;
			while( temp <= last) {
				int j = temp % N ;
				if(j==0) j = N;
				if(j==y) break;
				temp += M;
			}
			
			if ( temp > last) {
				System.out.println(-1);
			} else {
				System.out.println(temp);
			}
			
		}
	}
	
	static int least(int M, int N ) {
		return M * N / GCD(M,N);
	}
	static int GCD(int M, int N) {
		while(N!= 0) {
			int r = M%N;
			M = N;
			N = r;
		}
		return M;
	}
}
