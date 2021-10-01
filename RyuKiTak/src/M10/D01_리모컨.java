package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D01_리모컨 {
	static int N, M;
	static int now;
	static int answer;
	static boolean[] number = {true, true, true, true, true
								,true, true, true, true, true};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String Nstr = br.readLine();
		N = Integer.parseInt(Nstr);
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			number[Integer.parseInt(st.nextToken())] = false;
		}
		System.out.println(Arrays.toString(number));
		answer = Integer.MAX_VALUE;
		now = 100;
		
		// 1, 100부터 출발 하기
		answer = Math.min(answer, Math.abs(N - now));
		
		// 2. N 보다 큰수중에서 제일 작은수
		String bigger = "";
		for (int i = 0; i < Nstr.length(); i++) {
			int find = Nstr.charAt(i) - '0'; // 찾을수 
			while(true) {
				System.out.println(find);
				if (number[find] == true) {
					bigger += Integer.toString(find);
					break;
				}
				find += 1;
				if (find > 9) {
					bigger += Integer.toString(9);
					break;
				}
			}
		}
		System.out.println("큰수중에 제일 작은 거 " + bigger);
		answer = Math.min(answer, Math.abs(Integer.parseInt(bigger) - N  + Nstr.length()));
		
		// 3. N 보다 작은 수 중에서 제일 큰 수 
		String smaller = "";
		int temp = Integer.parseInt(Nstr);
		for (int i = Nstr.length()-1; i >= 0; i--) {
			int find = Nstr.charAt(i) - '0'; // 찾을수 
			while(true) {
				if (number[find] == true) {
					smaller += Integer.toString(find);
					break;
				}
				find -= 1;
				if (find < 0) {
					
					break;
				}
			}
		}

		System.out.println(smaller);
		answer = Math.min(answer, Math.abs(Integer.parseInt(smaller) - N) + Nstr.length());
		System.out.println("답");
		System.out.println(answer);
	}

}
