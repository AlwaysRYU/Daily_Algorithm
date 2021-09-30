package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D29_연속합2_2트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int answer[][] = new int[2][N];
		int maxx;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer[0][0] = arr[0];
		answer[1][0] = 0;
		maxx = arr[0];
		
		for (int i = 1; i < N; i++) { 
			// 현재수 i를 포함할 경우
			// (이전까지의 연속합 ) VS (쌩 i 값)
			// answer[0]은 중간에 삭제를 하지 않은 경우 이다.
			// 그래서  answer[1][i-1] + arr[i] 를 해주면 안된다.
			answer[0][i] = Math.max(answer[0][i-1] + arr[i], arr[i]);
			
//			answer[0][i] = Math.max(answer[0][i-1] + arr[i], Math.max(arr[i], answer[0][i-1] + arr[i]));
			// 이렇게 해도 답은 나온다. 하지만 정확하지 않다.
			
			// 현재수 i를 포함하지 않는 경우
			// ( 이전까지의 삭제하지않은 경우 == 즉 i를 안 넣는 경우  ) VS ( 이전에 삭제한 경우 + i 넣는 경우  )
			answer[1][i] = Math.max(answer[0][i-1], answer[1][i-1] +  arr[i]);
			
			maxx = Math.max(maxx, Math.max(answer[0][i], answer[1][i]));
		}
		
		for (int i = 0; i < 2; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
		System.out.println(maxx);
		
	}

}
