package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1748
public class D14_수이어쓰기1_2트 {
	
	public static void main(String[] args) throws Exception {
		int answer = 0;
		int len = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputstr = br.readLine();
		int N = Integer.parseInt(inputstr);
		
		int ten = 10;
		for (int i = 1; i <= N; i++) {
			if ( i % ten == 0 ) {
				len += 1;
				ten *= 10;
			}
			answer += len;
		}
		System.out.println(answer);
	}
}
