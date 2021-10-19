package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_2제출용 {
	static int totalcount;
	static int N;
	static int[][] field;
	
	public static void main(String args[]) throws Exception {
		// 기본 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		
		// 변수 설정
		int PX = 0 ;
		int PY = 0;
		
		// 테스트 케이스
		int Test = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Test; tc++) {
			totalcount = 0;
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());					
					if (field[i][j] == 2) {
						PX = i;
						PY = j;						
					}
				}
			}
			
			// 연산
			DFS(PX,PY,1);
			
			
			
			// 정답 제출
			bw.append("#" + tc + " " + totalcount + "\n");
			
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	
	static int[] dx = { 0,1,-1,0};
	static int[] dy = { 1,0,0,-1};
	private static void DFS(int pX, int pY, int time) {
		if (time >=4 ) {
			return;
		}
		
		// 1. 사방으로 갈 수 있는 위치를 계산해서 DFS돌리기.
		for (int dir = 0; dir < 4; dir++) {
			
			boolean jump = false;
			int X = pX;
			int Y = pY;
			int plus = 0;
			
			while ( true ) {
				X += dx[dir];
				Y += dy[dir];
				if ( X<0 || Y<0 || X>= N || Y>= N) break;
				
				if ( jump == false && field[X][Y] == 1) {
					jump = true;
					continue;
					// 이제 점프가능
				}
				
				if ( jump && field[X][Y] == 0 ) {
					// 점프한 상태고 빈공간이라면 갈 수 있다. 
					if (time+1 <= 3) {
						DFS(X,Y,time+1);
					}
				} else if ( jump && field[X][Y] == 1 ) {
					// 점프한 상태고 바둑알이 있다면 잡을 수 있다.
//					System.out.println(time + "번째 점프에 " + X +  "," +  Y  + " 위치에 있는 거 잡음 ");
					totalcount += 1;
					if (time+1 <= 3) {
						field[X][Y] = 0;
						DFS(X,Y,time+1); 
						field[X][Y] = 1; // 계산을 위해 원래대로 되돌려 놓음
					}
				}
				
			}
			
			
		}
		
		// 타임이 3일경우는 마지막임
		
		
		
		
	}
}
