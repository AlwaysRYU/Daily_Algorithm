package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 가장긴증가부분수열4_14002 {
	static int N, len, lastIndex;
	static int[] input;
	static int[] link;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		link = new int[N];
		LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		len = 0;
		
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i] && LIS[j] >= LIS[i]) {
					LIS[i] = LIS[j] + 1;
					link[i] = j;
				}
			}
			if (len < LIS[i]) {
				len = LIS[i];
				lastIndex = i;
			}
		}
		// 오름차순 출력 위해 스택에 푸시
		Stack<Integer> s = new Stack<>();
		int i = lastIndex;
		int cnt = 0;
		while (cnt < len) {
			s.push(input[i]);
			i = link[i];
			cnt++;
		}
		
		System.out.println(len);
		while (!s.isEmpty()) System.out.print(s.pop() + " ");
	}
}
