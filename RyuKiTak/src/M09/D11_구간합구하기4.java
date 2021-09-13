package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11659
public class D11_구간합구하기4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] sumarr = new int[N];
		
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			sumarr[i] = sum;
		}
		System.out.println(Arrays.toString(sumarr));
		// M번 만큼
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int Start = Integer.parseInt(st.nextToken()) - 2 ;
			int End = Integer.parseInt(st.nextToken()) - 1;
			int answer;
			if (Start < 0) {
				answer = sumarr[End];
			}
			else {
				answer = sumarr[End] - sumarr[Start];
					
			}
			System.out.println(answer);
		}
	}

}
