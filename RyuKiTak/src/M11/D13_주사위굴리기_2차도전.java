package M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D13_주사위굴리기_2차도전 {
	static int N,M,x,y,K;
	static int[][] field;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = { 0, 0, -1, 1};
	static int[] dy = { 1, -1, 0,0};
	// 주사위 관련 변수들
	// 가로
	static int[] horizontal = new int[3];
	// 세로
	static int[] vertical = new int[3];
	// 바닥
	static int floor;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		2
//	  4	1 3
//	    5
//	    6
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			// 동 1 서 2 북 3 남 4
			int order = Integer.parseInt(st.nextToken()) -1;
			//System.out.println(order);
			// 명령어는 배열과 같다.
			
			//
			int nx = x + dx[order];
			int ny = y + dy[order];
			if ( nx <0 || nx >= N || ny < 0 || ny >= M ) {
				continue;
				// 범위넘으면 무시함
			}
			
			// 1. 주사위 이동
			dicemove(order);
			
//			System.out.println("지금 위치 " + nx + " , " + ny );
			if ( field[nx][ny] != 0 ) {
				// 0이 아니면
				
				// 칸에 쓰여잇는 수가 주사위 바닥에 복사,
				floor = field[nx][ny];
				// 칸의 수가 0이됨
				field[nx][ny] = 0;
			} else {
				// 이동한 칸에 쓰여있는 수가 0이면
				
				// 주사위 바닥면에 쓰여 있는 수가 복사
				field[nx][ny] = floor;
				
			}
			
			
			// 주사위의 윗면에 쓰여있는 수 출력
			bw.append(Integer.toString(horizontal[1]) + "\n");
			
			x = nx;
			y = ny;
		}
//		System.out.println("답출력");
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 가로 horizontal
	// 세로 vertical
	// 바닥 floor
	private static void dicemove(int order) {
		// 동 1 서 2 북 3 남 4
		int temp;
		switch(order) {
			case 0 :
				// 동

				//
				temp = horizontal[2];
				horizontal[2] = horizontal[1];
				horizontal[1] = horizontal[0];
				horizontal[0] = floor;
				floor = temp;
				// 중앙교체 
				vertical[1] = horizontal[1]; 
				break;
			case 1 :
				// 서
				temp = horizontal[0];
				horizontal[0] = horizontal[1];
				horizontal[1] = horizontal[2];
				horizontal[2] = floor;
				floor = temp;
				vertical[1] = horizontal[1]; 
				break;
			case 2:
				// 북
				temp = vertical[0];
				vertical[0] = vertical[1];
				vertical[1] = vertical[2];
				vertical[2] = floor;
				floor = temp;
				horizontal[1] = vertical[1];
				break;
			case 3:
				// 남
				temp = vertical[2];
				vertical[2] = vertical[1];
				vertical[1] = vertical[0];
				vertical[0] = floor;
				floor = temp;
				horizontal[1] = vertical[1];
				break;
		}
	}

}
