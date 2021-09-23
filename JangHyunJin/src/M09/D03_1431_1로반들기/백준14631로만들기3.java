package dynnamic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 백준14631로만들기3 {
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		System.out.println(dp(N));
	}
	
	private static int dp(int N) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(N, 0));
		int ans = Integer.MAX_VALUE;
		visited[N] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int num = node.num;
			int cnt = node.cnt;
			
			if(num == 1) {
				ans = cnt;
				break;
			}
			if(!visited[num - 1]) {
				q.add(new Node(num - 1, cnt + 1));
				visited[num - 1] = true;
			}
			
			if(!visited[num / 2] && num % 2 == 0) {
				q.add(new Node(num / 2, cnt + 1));
				visited[num / 2] = true;
			}
			if(!visited[num / 3] && num % 3 == 0) {
				q.add(new Node(num / 3, cnt + 1));
				visited[num / 3] = true;
			}
		}
		return ans;
	}
	
	static class Node {
		int num, cnt;

		public Node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
}
