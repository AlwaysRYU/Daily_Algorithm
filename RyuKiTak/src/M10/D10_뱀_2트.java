package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3190
public class D10_뱀_2트 {
	
	static int N;
	static int K; // 사과개수
	static int L; // 방향 변환 횟수 L
	static int[][] field;
	static int time; // 게임시간
	static boolean isOver;
	static int snake_direction;
	static int HX, HY; // 뱀 머리 위치
	static Queue<int[]> snakeQ = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		// 보드의 크기 N
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// 사과 개수
			int X = Integer.parseInt(st.nextToken()) - 1;
			int Y = Integer.parseInt(st.nextToken()) - 1;
			field[X][Y] = 1;
			// -1 은 애플
		}
		
		// 초기화
		
		time = 0;
		isOver = false;
		snake_direction = 1; // 첨 방향은 우측이다.
		// 뱀 머리 위치
		HX = HY = 0;
		field[HX][HY] = 8;
		snakeQ.add(new int[] {0,0});
		
		// 뱀의 방향전환/
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int ontime = Integer.parseInt(st.nextToken()) - time;
			char direct = st.nextToken().charAt(0);
			
			// 2.
			// ontime 뒤에, 방향을 바꿔라.
			snake(ontime, direct);
			
			if(isOver) break;
			// 3. 시간바꿔주기
		}
		
		if(isOver == false ) {
			snake(N,'R');
		}
		System.out.println(time+1);
		
	}
	
	// 우측으로 -> 좌측으로 <-
	static int[] dx = { -1, 0, 1,  0};
	static int[] dy = {  0, 1, 0, -1};
	static void snake(int ttime, char LR) {
//		System.out.println(LR);
//		System.out.println(ttime + " 동안 " + snake_direction + " 방향으로 이동할 것입니다.");
		
		for (int i = 0; i < ttime; i++) {
			// 1. 시간만큼 이동
			
			// 가. 이동하기
			HX += dx[snake_direction];
			HY += dy[snake_direction];
		
			// 나. 만약 벽/ 몸통이면 게임끝
			if ( HX < 0 || HX >= N || HY < 0 || HY >= N 
					|| field[HX][HY] == 8 ) {
				isOver = true;
				if(isOver) return;
			}
			
			if ( field[HX][HY] == 0 ) {
				// 빈공간이면 
				// 꼬리 이동
				int[] temp = snakeQ.poll();
//				System.out.println(Arrays.toString(temp));
				field[temp[0]][temp[1]] = 0;
				
				// 필드 수정
				field[HX][HY] = 8;

				snakeQ.add(new int[] {HX,HY} );
//				field[HX - dx[snake_direction]][HY - dy[snake_direction]] = 1;
				
			} else if ( field[HX][HY] == 1 ) {
				// 사과면 
				field[HX][HY] = 8;
				snakeQ.add(new int[] {HX,HY} );
			}
			
			// 이동완료 
			
			
			
			
			// 필드출력
//			System.out.println("필드 상황");
//			for (int j = 0; j < N; j++) {
//				for (int j2 = 0; j2 < N; j2++) {
//					System.out.print(field[j][j2] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("지금 머리 " + HX + " , " + HY);
//			System.out.println();
			
			time += 1;
		}
		
		// 3. 이동 완료 후 방향 회전시켜주기
		if (LR == 'L') {
			// 좌회전 
//			System.out.println("좌회전");
			snake_direction -= 1;
			if(snake_direction == -1) snake_direction = 3;
		} else {
			// 우회전

//			System.out.println("우회전");
			snake_direction += 1;
			if(snake_direction == 4) snake_direction = 0;
		}
					
		
	}
	
}
