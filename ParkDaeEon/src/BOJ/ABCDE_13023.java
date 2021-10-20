package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {
	static List<Integer>[] adjList;
	static boolean[] visit;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
		
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
		}
		System.out.println(ans);
	}

	static void dfs(int v, int depth) {
		if (ans == 1) return;
		if (depth == 4) {
			ans = 1;
			return;
		}
		for (int adjV : adjList[v]) {
			if (!visit[adjV]) {
				visit[adjV] = true;
				dfs(adjV, depth + 1);
				visit[adjV] = false;
			}
		}
	}
}
