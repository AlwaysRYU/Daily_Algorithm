package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1748
public class D14_수이어쓰기1 {
	
	public static void main(String[] args) throws Exception {
		String answer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			answer += Integer.toString(i);
		}
		System.out.println(answer.length());
	}
}
