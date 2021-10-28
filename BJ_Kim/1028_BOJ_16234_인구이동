package prob_인구이동_16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Main {
	static int N,L,R,count = 1,count2,sum,day;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<Node> queue = new LinkedList();
	static ArrayList<Node>[][] al;
	static int[][] ar;
	static boolean[][] visit;
	static boolean[][] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				al[i][j] = new ArrayList<Node>();
			}
		}
		ar = new int[N][N];
		visit = new boolean[N][N];
		selected = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(day-1 > 2000) {
			System.out.println(2000);
		}
		else {
			System.out.println(day-1);
		}
		
	}
	//연결이 따로 되어 있는 경우...
	//1. 인접 리스트에 추가
	//2. 추가하는 과정이 끝났으면 연결된 녀석들끼리 연합을 생성
	//(bfs를 돌리면서 더이상 늘어날 곳이 없으면 해당 연합 확정이지 않을까)
	//3. 각 연합끼리의 연산 진행
	static void bfs() {
		while(count != 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					al[i][j] = new ArrayList<Node>();
				}
			}
			day++;
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) { //해당 정점이 방문되지 않은 정점이면
						visit[i][j] = true; //현 위치 방문 처리
						queue.offer(new Node(i,j)); //노드 삽입
						while(!queue.isEmpty()) { //큐가 비지 않는다면 무한반복
							Node node = queue.poll(); //값 꺼내오기
							for (int k = 0; k < 4; k++) {
								int ny = node.y + dy[k];
								int nx = node.x + dx[k];
								if(ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx]) continue;
								if(Math.abs(ar[node.y][node.x] - ar[ny][nx]) >= L && Math.abs(ar[node.y][node.x] - ar[ny][nx]) <= R) {
									count++; //인접 갯수를 출력(인접 개수가 0개면 끝.)
//									System.out.println("L값은 " + L);
//									System.out.println("차이 : " + Math.abs(ar[node.y][node.x] - ar[ny][nx]));
									queue.offer(new Node(ny,nx));
									visit[ny][nx] = true;
									al[node.y][node.x].add(new Node(ny,nx)); // 인접 리스트에 추가
								}
							}
						}
					}
				}
			}
			if(count == 0) return; //연합 되는 녀석이 하나도 없으면 --
			//추가하는 과정이 끝났으면 연결된 녀석들끼리 연합을 생성
			// 연합 생성 : 리스트 크기가 0이 아닌 녀석을 발견한 경우,
			// 1) 인접한 녀석들의 합을 모두 더함
			// 2) 해당 모든 요소들의 값은 (구한 합/요소 개수)가 된다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(al[i][j].size() > 0 && !selected[i][j]) {
						queue.offer(new Node(i,j));
						count2++;
						sum += ar[i][j];
						selected[i][j] = true;
						while(!queue.isEmpty()) {
							Node node = queue.poll();
							for (int j2 = 0; j2 < al[node.y][node.x].size(); j2++) {
								if(!selected[al[node.y][node.x].get(j2).y][al[node.y][node.x].get(j2).x]) {
									count2++;
									selected[al[node.y][node.x].get(j2).y][al[node.y][node.x].get(j2).x] = true;
									queue.offer(new Node(al[node.y][node.x].get(j2).y,al[node.y][node.x].get(j2).x));
									sum+= ar[al[node.y][node.x].get(j2).y][al[node.y][node.x].get(j2).x];
//									System.out.println(j2);
								}
							}
						}
//						System.out.println(sum);
//						System.out.println(count2);
						//해당 연합을 다 찾았으면
						queue.offer(new Node(i,j)); // 다시 노드를 집어넣고
						ar[i][j] = sum/count2;
						while(!queue.isEmpty()) { // 연합을 다시 조사
							Node node = queue.poll(); 
							for (int j2 = 0; j2 < al[node.y][node.x].size(); j2++) { //해당 리스트를 조사해서 
								if(selected[al[node.y][node.x].get(j2).y][al[node.y][node.x].get(j2).x]) { // 선택된 녀석이라면(없어도 될듯)
//									selected[al[node.y][node.x].get(j2).y][al[node.y][node.x].get(j2).x] = false;
									queue.offer(new Node(al[node.y][node.x].get(j2).y,al[node.y][node.x].get(j2).x)); // 모든 부분을 탐색해야 하니 필요할듯
									ar[al[node.y][node.x].get(j2).y][al[node.y][node.x].get(j2).x] = sum/count2; // 해당 연합의 공통 값들을 지정!
								}
							}
						}
					}
					sum = 0;
					count2 = 0;
				}
			}
			visit = new boolean[N][N];
			selected = new boolean[N][N];
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(ar[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
	}
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
