package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17281
public class D09_야구 {
	static int N;
	static int[][] batting;
	
	static int[] order = new int[9]; // 치는 순서
	static boolean[] visit = new boolean[9];
	static int answer = 0; // 최대 점수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		batting = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				batting[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		baseball(0);
		System.out.println(answer);
		
//		order = new int[] {0,4,1,2,3,5,6,7,8};
//		baseball(9);
//		System.out.println(answer);
	}

	private static void baseball(int depth) {
		if (depth == 9 ) {
			//System.out.println(Arrays.toString(order));
			
			// 2. 계산시작
			int inning = 0; // 배팅의 세로줄 
			int hitterIDX = 0;
			int outcount = 0;
			int nowanswer = 0;
			Queue<Integer> field = new LinkedList<Integer>();
			while(true) {
				
				if ( inning >= N) break; // 이닝 끝나면 종료
				
				int hit = batting[inning][order[hitterIDX]];
				//System.out.println(order[hitterIDX] + "번 선수, " + hit + " 쳤습니다.");
				if ( hit == 0 ) {
					// 아웃일 경우
					outcount += 1;
					if ( outcount == 3) {
						field.clear();
						inning += 1;
						//System.out.println(inning + "회 점수 " + nowanswer);
						outcount = 0;
					}
				} else if ( hit == 1 ) {
					field.add(1);
					while( field.size() > 3) {
						int homein = field.poll();
						if ( homein == 1) {
							nowanswer += 1;
						}
					}
					
				} else if ( hit == 2 ) {
					// 2루타
					field.add(1);
					field.add(0);
					while( field.size() > 3) {
						int homein = field.poll();
						if ( homein == 1) {
							nowanswer += 1;
						}
					}
				} else if ( hit == 3 ) {
					// 3루타
					field.add(1);
					field.add(0);
					field.add(0);
					while( field.size() > 3) {
						int homein = field.poll();
						if ( homein == 1) {
							nowanswer += 1;
						}
					}
				} else {
					// 홈런
					field.add(1);
					while( !field.isEmpty()) {
						int homein = field.poll();
						if ( homein == 1) {
							nowanswer += 1;
						}
					}
				}
				hitterIDX += 1;
				if (hitterIDX == 9 ) {
					hitterIDX = 0;
				}
			}
			
			if ( nowanswer > answer ) {
				answer = nowanswer;
				//System.out.println(Arrays.toString(order) + " 현재 타격 순서 " + nowanswer);
				
			}
			return;
		}
		
		// 3번은 고정이다.
		if ( depth == 3) {
			order[depth] = 0;
			visit[0] = true;
			baseball(depth+1);
		}
		for (int i = 1; i < 9; i++) {
			if ( !visit[i] ) {
				visit[i] = true;
				order[depth] = i;
				baseball(depth+1);
				visit[i] = false;
			}
		}
	}

}
