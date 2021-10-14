package M10;

//https://www.acmicpc.net/problem/17070

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D15_파이프옮기기1 {
	static int N;
	static int[][] field;
	static int[][] count;
	static boolean[][] visit;
	static int answer;
	
	static Queue<pipe> Q = new LinkedList<>();
	static class pipe {
		int x;
		int y; // 이건 파이프 끝자리
		int type;
		int count;
		
		
		@Override
		public String toString() {
			return "pipe [x=" + x + ", y=" + y + ", type=" + type + ", count=" + count + "]";
		}
		
		public pipe() {}
		public pipe(int x, int y, int type, int count) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.count = count;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		count = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				count[i][j] = 1_000_001;
			}
		}
		
		//초기화
		count[0][0] = 0;
		count[0][1] = 0;
		visit[0][0] = visit[0][1] = true;
		answer = 0;
		
		dfs(new pipe(0,1,1,0));
		
		System.out.println(answer);
		
	}
	
	static boolean check(int nx, int ny) {
		if ( nx<0 || ny <0 || nx>= N || ny >= N 
				|| visit[nx][ny] == true || field[nx][ny] == 1 ) return false;
		return true;
	}
	
	private static void dfs(pipe pipe) {
		int nx;
		int ny;
		if (pipe.x == N-1 && pipe.y==N-1) answer += 1;
		
		if (pipe.type == 1) {
			
			// 1. 
			nx = pipe.x + 0;
			ny = pipe.y + 1;
			if ( check(nx,ny) ) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 1, pipe.count ));
				visit[nx][ny] = false;
			}
			
			// 3. 타입 3 경우 
			nx = pipe.x + 1;
			ny = pipe.y + 1;
			if ( check(pipe.x+1,pipe.y+1) 
					&& check(pipe.x+1,pipe.y)
					&& check(pipe.x,pipe.y+1)) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 3, pipe.count ));
				visit[nx][ny] = false;
			}
			
			
		} else if (pipe.type == 2) {
			// 2. 
			nx = pipe.x + 1;
			ny = pipe.y + 0;
			if ( check(nx,ny) ) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 2, pipe.count ));
				visit[nx][ny] = false;
			}
			// 3. 타입 3 경우 
			nx = pipe.x + 1;
			ny = pipe.y + 1;
			if ( check(pipe.x+1,pipe.y+1) 
					&& check(pipe.x+1,pipe.y)
					&& check(pipe.x,pipe.y+1)) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 3, pipe.count ));
				visit[nx][ny] = false;
			}
			
		} else {
			// 파이프 타입이 대각선 
			
			// 1. 
			nx = pipe.x + 0;
			ny = pipe.y + 1;
			if ( check(nx,ny) ) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 1, pipe.count ));
				visit[nx][ny] = false;
			}
			
			// 2. 
			nx = pipe.x + 1;
			ny = pipe.y + 0;
			if ( check(nx,ny) ) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 2, pipe.count ));
				visit[nx][ny] = false;
			}
			
			// 3. 타입 3 경우 
			nx = pipe.x + 1;
			ny = pipe.y + 1;
			if ( check(pipe.x+1,pipe.y+1) 
					&& check(pipe.x+1,pipe.y)
					&& check(pipe.x,pipe.y+1)) {
				visit[nx][ny] = true;
				dfs(new pipe(nx,ny, 3, pipe.count ));
				visit[nx][ny] = false;
			}
		}
		
		
	}

}
