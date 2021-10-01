package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 최소비용구하기2_11779 {
	static int N, M, A, B, pathLength;
	static int[] cost;
	static int[] parent;
	static boolean[] visit;
	static List<List<Edge>> adjList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N + 1];
		cost = new int[N + 1];
		parent = new int[N + 1];
		
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
		// 최소 비용 출력
		System.out.println(cost[B]);
		// 최소 경로 도시 개수, 최소 경로 출력
		Stack<Integer> stack = new Stack<>();
        int cur = B;
        while(cur != A) {
            stack.push(cur);
            pathLength++;
            cur = parent[cur];
        }
        stack.push(cur);
        pathLength++;
        System.out.println(pathLength);
        while(!stack.isEmpty()){
            int city = stack.pop();
            System.out.print(city + " ");
        }
	}
	
	static void dijkstra() {
		Queue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
		pq.offer(new Edge(A, 0));
		cost[A] = 0;
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int cv = e.v;
			int cc = e.cost;
			
			if (visit[cv]) continue;
			visit[cv] = true;
			
			for (Edge adjEdge : adjList.get(cv)) {
				int nv = adjEdge.v;
				int nc = cc + adjEdge.cost;
				
				if (nc < cost[nv]) {
					cost[nv] = nc;
					pq.offer(new Edge(nv, nc));
					parent[nv] = cv;
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
