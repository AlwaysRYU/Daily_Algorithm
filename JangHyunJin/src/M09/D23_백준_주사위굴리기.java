import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class 주사위굴리기{
	
	private static int N, M, K, X, Y;
	private static int[][] map;
	private static int[] comm;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comm = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			comm[i] = Integer.parseInt(st.nextToken());
		}
		go();
		br.close();
	}
	public static void go() throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int index = 0;
		int nowX = X;
		int nowY = Y;
		Dice dice = new Dice();
		while(index<comm.length) {
			int nx = nowX + dx[comm[index]-1];
			int ny = nowY + dy[comm[index]-1];
			if(nx<0 || ny<0 || nx>=N || ny>=M) {
				index++;
				continue;
			}
			switch(comm[index]){
			case 1 :
				dice.moveEast();
				break;
			case 2 :
				dice.moveWest();
				break;
			case 3 :
				dice.moveNorth();
				break;
			case 4 :
				dice.moveSouth();
				break;
			}
			if(map[nx][ny] == 0) map[nx][ny] = dice.b;
			else {
				dice.b = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			nowX = nx;
			nowY = ny;

			index++;
			bw.write(dice.t + "\n");
			bw.flush();
		}
		bw.close();
	}
	public static class Dice{
		int w, e, s, n, t, b;
		public Dice() {
			this.w = 0;
			this.e = 0;
			this.s = 0;
			this.n = 0;
			this.t = 0;
			this.b = 0;
		}
		public void moveEast() {
			int temp = t;
			t = w;
			w = b;
			b = e;
			e = temp;
		}
		public void moveWest() {
			int temp = t;
			t = e;
			e = b;
			b = w;
			w = temp;
		}
		public void moveNorth() {
			int temp = t;
			t = s;
			s = b;
			b = n;
			n = temp;
		}
		public void moveSouth() {
			int temp = t;
			t = n;
			n = b;
			b = s;
			s = temp;
		}
	}
}