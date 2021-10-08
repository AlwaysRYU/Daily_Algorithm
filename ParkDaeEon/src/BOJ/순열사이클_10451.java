package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 그래프 탐색 방법으로 풀어보면 좋을 듯
 */
public class 순열사이클_10451 {
	static int T, N;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		parent = new int[1001];
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			make();
			
			for (int i = 1; i <= N; i++) {
				int n = Integer.parseInt(st.nextToken());
				union(i, n);
			}
			
			for (int i = 1; i <= N; i++) findParent(i);
			int cnt = 0;
			for (int i = 1; i <= N; i++) if (parent[i] == i) cnt++;
			System.out.println(cnt);
		}
	}
	
	static void make() {
		for (int i = 1; i <= N; i++)
			parent[i] = i;
	}
	
	static int findParent(int v) {
		if (parent[v] == v) return v;
		return parent[v] = findParent(parent[v]);
	}
	
	static void union(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if (pa == pb) return;
		if (pa < pb) parent[a] = b;
		else parent[b] = a;
	}
}
