package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소비용구하기_1916 {
	static int N, M, A, B;
	static int[] cost;
	static boolean[] visit;
	static List<List<Edge>> adjList = new ArrayList<>();
	static Queue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N + 1];
		cost = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
			cost[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList.get(from).add(new Edge(to, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(cost[B]);
	}
	
	static void dijkstra() {
		cost[A] = 0;
		pq.offer(new Edge(A, 0));
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (visit[e.v]) continue;
			visit[e.v] = true;
			
			int cv = e.v;
			for (Edge adjEdge : adjList.get(cv)) {
				int c = e.cost + adjEdge.cost;
				
				if (c < cost[adjEdge.v]) {
					cost[adjEdge.v] = c;
					adjEdge.cost = c;
					pq.offer(adjEdge);
				}
			}
		}
	}
	
	static class Edge {
		int v, cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
}
