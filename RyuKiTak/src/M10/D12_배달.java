package M10;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
public class D12_배달 {
	
	
	static class Edge {
		int From;
		int To;
		int Value;
		public Edge(int from, int to, int value) {
			super();
			From = from;
			To = to;
			Value = value;
		}

		@Override
		public String toString() {
			return "Edge [From=" + From + ", To=" + To + ", Value=" + Value + "]";
		}
		
		
	}
	static int solution(int N, int[][] road, int K) {
	       // 1번 마을에서 갈 수 있는 걸 출력해야함
	        
	        // 다익스트라
	        
	        // 1. 초기화 및 설정
	        int[][] cost = new int[N][N];
	        for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cost[i][j] = 999999;
				}
			}
	        int[][] map = new int[N][N];
	        boolean[] visit = new boolean[N];
	       
	        for (int i = 0; i < road.length; i++) {
	        	int start = road[i][0] -1;
	        	int to = road[i][0] -1 ;
	        	int value = road[i][0];
	        	map[start][to] = value;
	        	map[to][start] = value;
			}
	        
	        /// 우선순위 큐
	        PriorityQueue<Edge> PQ = new PriorityQueue<>(
				(e1, e2) -> e1.Value - e2.Value
				);
	        
	        // 가. 시작지점
	        cost[0][0] = map[0][0];
	        visit[0] = true;
	        PQ.offer(new Edge(0,0,0));
	        
	        // 나. 큐돌리기 시작
	        while( !PQ.isEmpty() ) {
	        	// A. 큐에서 간선 꺼내기
	        	// 얘는 제일 작은 놈이다.
	        	Edge e = PQ.poll();
	        	
	        	// B. 꺼낸 좌표 XY를 기준으로 탐색 시작한다.
	        	
	        	for (int i = e.From ; i < N; i++ ) {
	        		
	        		if ( map[e.From][i] == 0  || visit[i] ) continue;
	        		
//	        		C. 방문하지 않고  범위내라면
	        		if ( e.Value + map[e.From][i] < cost[e.From][i] ) {
	        			visit[i] = true;
	        			cost[e.From][i] = e.Value + map[e.From][i];
	        			PQ.offer(new Edge(e.From,i, cost[e.From][i]));
	        		}
	        		
	        	}
	        }// : 탐색 종료
	        
	        // 0에서 갈 수 있는 개수 세기
	        System.out.println(Arrays.toString(cost[0]));
	        int count = 0;
        	for (int i = 1; i < N; i++) {
				if ( cost[0][i] <= 3 ) count += 1;
			}

	        return count;
	    }
	
	public static void main(String[] args) throws Exception {
		int N;
		int[][] road;
		int K;
		
		road = new int[][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		N = 5;
		K = 3;
		System.out.println((solution(N,road,K)));
		
		road = new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		N = 6;
		K = 4;
		System.out.println((solution(N,road,K)));
		
	
	
	}
}
