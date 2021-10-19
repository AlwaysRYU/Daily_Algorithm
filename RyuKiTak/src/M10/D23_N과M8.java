package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15654
public class D23_N과M8 {
	static int N, M;
	static int[] answer;
	static boolean[] visit;
	static ArrayList<Integer> number;
	static StringBuilder sb;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception {
		// 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		sb = new StringBuilder();
		
		// N과 M
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(number);
		
		// 3 : 1~N까지 자연수 중에서 M개를 고른 수열
		// 같은 수를 여러번 골라도 괜괜찮다.
		visit = new boolean[N];
		answer = new int[M];
		N_and_M(0,0);
		
		// 출력
		bw.flush();
		
		//
		br.close();
		bw.close();
	}

	private static void N_and_M(int depth, int index) throws Exception {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				bw.write(answer[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		
		for (int i = index; i < N; i++) {
			answer[depth] = number.get(i);
			N_and_M(depth+1, i);
		}
		
		
	}

}
