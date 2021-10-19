package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D18_N과M3 {
	static int N, M;
	static int[] answer;
	static StringBuilder sb;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception {
		// 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		
		// N과 M
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		// 3 : 1~N까지 자연수 중에서 M개를 고른 수열
		// 같은 수를 여러번 골라도 괜괜찮다.
		answer = new int[M];
		N_and_M(0);
		
//		System.out.print(sb);
		
		//
		
		// 출력
		bw.flush();
		
		//
		br.close();
		bw.close();
	}

	private static void N_and_M(int depth) throws Exception {
		if(depth == M) {
			
//			for (int i = 0; i < M; i++) {
//				System.out.print(answer[i] + " ");
//			}
//			System.out.println();
		
			for (int i = 0; i < M; i++) {
//				sb.append(answer[i] + " ");
				bw.write(answer[i] + " ");
			}
			bw.write("\n");
//			sb.append('\n');
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			answer[depth] = i+1;
			N_and_M(depth+1);
		}
	}

}
