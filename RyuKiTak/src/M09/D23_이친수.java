package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D23_이친수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] crazy = new long[91];
		
		// 11이 들어가지않는 이진수의 개수 저장하는 배열
		long[] only = new long[95];
		only[1] = 2;
		only[2] = 3;
		for (int i = 3; i < 95; i++) {
			only[i] = only[i-1] + only[i-2];
		}
		
		crazy[1] = 1;
		crazy[2] = 1;
		for (int i = 3; i < 91; i++) {
			crazy[i] = only[i-2];
		}
		
		System.out.println(crazy[N]);
	}

}
