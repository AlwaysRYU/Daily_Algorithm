package M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10971

public class D06_외판원순회2 {static int N;
static int arr[][];
static int min=Integer.MAX_VALUE;
static boolean visit[];
public static void main(String[] args) throws NumberFormatException, IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	N = Integer.parseInt(br.readLine());
	
	arr = new int[N][N];
	visit = new boolean[N];
	for(int i=0; i<N; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++) {
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	for(int i=0; i<N; i++) {
		dfs(i,i,0,0);
	}
	System.out.println(min);
	
}
public static void dfs(int start, int i, int cnt, int sum) {
	if(cnt == N && start==i) {
		min = Math.min(min, sum);
		return;
	}
	
	for(int idx=0; idx<N; idx++) {
		if(arr[i][idx]==0)
			continue;
		
		if(!visit[i] && arr[i][idx]>0) {
			visit[i] = true;
			sum += arr[i][idx];
			dfs(start, idx, cnt+1, sum);
			visit[i] = false;
			sum -= arr[i][idx];
		}
	}
	
	
}
}