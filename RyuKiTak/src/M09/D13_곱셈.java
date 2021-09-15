package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1629
public class D13_곱셈 {
	static long C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(POW(A,B));
		
	}
	
	public static long  POW(long A, long E) {
		// 지수가 1일 경우에 A그대로를 계산해서 리턴함.
		if (E == 1) return A%C;
		// 지수에 절반에 해당하는 A*(E/2)를 구한다.
		long temp = POW(A, E/2);
		
		if (E%2 == 1) {
			return (temp*temp%C) * A%C;
		}
		return  temp*temp%C;
		
	}

}
