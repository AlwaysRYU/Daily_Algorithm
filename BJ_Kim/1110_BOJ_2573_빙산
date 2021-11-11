package prob_2573_빙산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {

	static int N,M,mount,count,year;
	static int[][] ar;
	static boolean[][] visit;
	static Queue<Node> queue = new LinkedList<Node>();
	static int[] dy= {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<Node> list = new ArrayList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] != 0) list.add(new Node(i,j,ar[i][j]));
			}
		}
		bfs();
	}
	static void bfs() {
		while(!list.isEmpty()) {
			year++;
			for (int i = 0; i < list.size(); i++) { // 모든 요소에 대해 상호작용 진행
				for (int j = 0; j < 4; j++) {
					int ny = list.get(i).y + dy[j];
					int nx = list.get(i).x + dx[j];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if(ar[ny][nx] == 0) {
						count++;
					}
				}
				list.get(i).h -= count;
				count = 0;
			}
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).h <= 0) {
					ar[list.get(i).y][list.get(i).x] = 0;
					list.remove(i);
					i--;
					continue;
				}
				ar[list.get(i).y][list.get(i).x] = list.get(i).h;
			}
			if(list.isEmpty()) {
				System.out.println(0);
				return;
			}
			visit = new boolean[N][M];
			mount = 1; //상호작용 후 남아있는 빙산의 수
			queue.offer(list.get(0));
			visit[list.get(0).y][list.get(0).x] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = node.y + dy[i];
					int nx = node.x + dx[i];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M || ar[ny][nx] == 0 || visit[ny][nx]) continue;
					visit[ny][nx] = true;
					queue.offer(new Node(ny,nx,ar[ny][nx]));
					mount++;
				}
			} // 0번 기준 탐색이 끝나면 모든 정점을 탐색헀는지 검사
			if(mount != list.size()) {
				System.out.println(year);
				return;
			}
		}
		
	}
static class Node {
	int y;
	int x;
	int h;
	public Node(int y, int x, int h) {
		this.y = y;
		this.x = x;
		this.h = h;
	}
	
}
}
