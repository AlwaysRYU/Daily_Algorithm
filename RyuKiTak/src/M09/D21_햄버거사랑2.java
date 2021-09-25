package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D21_햄버거사랑2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		int small = Math.min(N, M);
		int big = Math.max(N, M);
		int temp;
		
		int coke = 0;
		while(true) {
			// 1. 지금 time으로 맞아 떨이지는지 확인한다.
			temp = (time / small);
			boolean find = false;
			while(true) {
				if (temp < 0) break;
				if ((time - (temp * small)) % big == 0) {
					find = true;
					break;
				}
				temp -= 1;
			}
			
			if (find) break;
			// 딱 안맞아 떨어질 경우 time 감소 
			time -= 1; 
			coke += 1;
		}
		
		int total = temp + (time - (temp * small)) / big;
		System.out.print(total + " ");
		System.out.println(coke);
	
	}

}
