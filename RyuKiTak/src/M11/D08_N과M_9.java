package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class D08_N과M_9 {
	static int N,M;
	static int[] arr, perm;
	static LinkedHashSet<String> ans;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		perm = new int[M];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = new LinkedHashSet<>();
		Arrays.sort(arr);
		Per(0);
		for(String XX : ans) {
			System.out.println(XX);
		}
		
		
	}
	
	static void Per(int depth) {
		if ( depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int XX : perm )
				sb.append(XX).append(' ');
			ans.add(sb.toString());
			return;
				
		}
		for (int i = 0; i < N; i++) {
			if ( visit[i]) continue;
			visit[i] = true;
			perm[depth] = arr[i];
			Per(depth + 1);
			visit[i] = false;
			
		}
	}

}
