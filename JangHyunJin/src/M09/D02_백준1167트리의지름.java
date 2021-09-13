package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준1167트리의지름 {

	static ArrayList<Node>[] node;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	static int farAwayPoint;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int E = Integer.parseInt(bf.readLine()) + 1;

		node = new ArrayList[E];
		visited = new boolean[E];

		for (int i = 1; i < E; i++) {
			node[i] = new ArrayList<Node>();
		}

		StringTokenizer sTokenizer = null;

		for (int i = 1; i < E; i++) {
			sTokenizer = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(sTokenizer.nextToken());
			int to = 0;
			while ((to = Integer.parseInt(sTokenizer.nextToken())) != -1) {
				int cost = Integer.parseInt(sTokenizer.nextToken());
				node[from].add(new Node(to, cost));
			}
		}
		
		
			visited[1] = true;
			dfs(1,0);
			
			visited = new boolean[E];
			
			visited[farAwayPoint] = true;
			dfs(farAwayPoint, 0);
		
		
		System.out.println(max);

	}

	private static void dfs(int n , int cost) {
		
		for (int i = 0; i < node[n].size(); i++) {
			Node temp = node[n].get(i);

			if(visited[temp.to])
				continue;
			
			visited[temp.to] = true;
			
			cost += temp.cost;
			if(max < cost) {
				max = cost;
				farAwayPoint = temp.to;
			}
			dfs(temp.to ,cost);	
			cost -= temp.cost;
		}
		
		
		
		
	}

	static private class Node {

		int to;
		int cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
	}
}
