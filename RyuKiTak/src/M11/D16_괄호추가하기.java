package M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//https://www.acmicpc.net/problem/16637
public class D16_괄호추가하기 {
	static int N;
	// 숫자
	static ArrayList<Integer> num;
	// 기호
	static ArrayList<Character> op;
	// 답
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		char[] cArr = br.readLine().toCharArray();
		
		num = new ArrayList<>();
		op = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if ( (i+1) % 2 == 1) {
				// 숫자 일경우 (인덱스가 홀수
				num.add(Character.getNumericValue(cArr[i]));
			} else {
				// 기호 일경우
				op.add(cArr[i]);
			}
		}
		
		// 젤처음 숫자부터
		dfs(0, num.get(0) );
		
		System.out.println(answer);
	}

	// 인덱스와 합
	private static void dfs(int idx, int sum) {
		// TODO Auto-generated method stub
		if ( idx == op.size() ) {
			// 끝에 도달하면 답 체크
			answer = Math.max(answer, sum);
			return;
		}
		dfs(idx+1, calculate(sum, num.get(idx+1), op.get(idx)));
		if (idx+2 <= op.size() ) {
			// 아직 범위내면
			dfs(idx + 2, calculate(sum, calculate(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx))); // 괄호 안 치고 넘기기
		}
		
	}

	private static int calculate(int a, int b, char op) {
		// TODO Auto-generated method stub
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}
