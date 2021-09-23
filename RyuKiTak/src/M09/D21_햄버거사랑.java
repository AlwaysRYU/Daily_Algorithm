package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D21_햄버거사랑 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		int small = Math.min(N, M);
		int big = Math.max(N, M);
		
		int small_ans = -1;
		int big_ans = -1;
		
		int colar = 0;
		boolean find = false;
		
		while(true) {
			
			int temp = time;
			int small_M = temp/small;
			
			while (true){
				if (small < 0 ) break;
				
				int temp2 = temp - small_M * small;
				if (temp2 % big == 0) {
					small_ans = small_M;
					big_ans = temp2/big;
					find = true;
					System.out.println("답 찾음");
					break;
				}
				
				small_M  -=1 ;
			}
			
			if (find) break;
			// 답이 안나왔을 경우
			{
			time -= 1;
			colar += 1;
			}
		}
		
		System.out.println(small_ans);
		System.out.println(big_ans);
//		System.out.println(small_ans + big_ans);
	}

}
