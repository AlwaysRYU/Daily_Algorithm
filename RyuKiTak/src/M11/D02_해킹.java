package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D02_해킹 {
	
	private static int N,D,C;
	private static int INF = Integer.MAX_VALUE;
	private static ArrayList<ArrayList<Node>> graph;
	
	private static class Node implements Comparable<Node> {
		int index, distance;

		public int getIndex() {
			return index;
		}
		public Node() {}
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			if ( this.distance < o.distance) {
				return -1;
			}
			return 1;	
		}
		
		
	}
	private static int[] dis = new int[10001];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while (t-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				graph.get(b).add(new Node(a,s));
			}
			
			
			Arrays.fill(dis, INF);
			
			dijstra(C);
			
			int cnt =0;
			int result = 0;
			for (int i = 1; i <= N; i++) {
				if (dis[i] != INF) {
					cnt += 1;
					result = Math.max(result, dis[i]);
				}
			}
			
			sb.append(cnt + " " + result+ "\n");
			
		}
		System.out.println(sb);
		
		
	}


	private static void dijstra(int start) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dis[start] = 0;
		
		while ( !pq.isEmpty() ) {
			Node node = pq.poll();
			int dist = node.distance;
			int now = node.index;
			if (dis[now] < dist ) {
				continue;
			}
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = dis[now] + graph.get(now).get(i).getDistance();
				
				if (cost < dis[graph.get(now).get(i).getIndex()]) {
					dis[graph.get(now).get(i).getIndex()] = cost;
					pq.add(new Node(graph.get(now).get(i).getIndex(), cost));
					
				}
			}
		}
		
	} // 다익슽르ㅏ
	
	

}
