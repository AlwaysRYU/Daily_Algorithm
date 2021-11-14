package M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D13_주사위굴리기 {
	static int N,M,x,y,K;
	static int[][] field;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = { 0, 0, -1, 1};
	static int[] dy = { 1, -1, 0,0};
	static int[][] dicerule = {
								{2,3,1,4,5},
								{2,3,5,0,4},
								{5,0,1,4,3},
								{0,5,1,4,2},
								{2,3,0,5,1},
								{2,3,4,1,0}	
								};
	
	static int[] dice = new int[6];
	
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
		
//		1
//	  3	0 2
//	    4
//	    5
		int badak = 5; // 젤처음 윗면이 1이고 동쪽이 3임
		// 즉 바닥이 5인상태
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
			
			// 주사위 바닥이 이동
			int temp = dicerule[badak][order];
			badak = temp;

			System.out.println("지금 위치 " + nx + " , " + ny );
			System.out.println("지금 바닥 번호 " + badak + " 천장 번호 : " + dicerule[badak][4]);
			System.out.println("지금 주사위 -> " + Arrays.toString(dice));
			System.out.println();
			if ( field[nx][ny] != 0 ) {
				// 0이 아니면
				
				// 칸에 쓰여잇는 수가 주사위 바닥에 복사,
				dice[badak] = field[nx][ny];
				// 칸의 수가 0이됨
				field[nx][ny] = 0;
			} else {
				// 이동한 칸에 쓰여있는 수가 0이면
				
				// 주사위 바닥면에 쓰여 있는 수가 복사
				field[nx][ny] = dice[badak];
				
			}
			
			
			// 주사위의 윗면에 쓰여있는 수 출력
			bw.append(Integer.toString(dice[dicerule[badak][4]]) + "\n");
			
			x = nx;
			y = ny;
		}
		System.out.println("답출력");
		bw.flush();
		bw.close();
		br.close();
	}

}
