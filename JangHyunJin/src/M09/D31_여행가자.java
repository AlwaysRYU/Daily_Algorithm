import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자{
	private static int[] set = null;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;

		int[][] map = new int[N + 1][N + 1];
		set = new int[N + 1];
		for(int i = 1; i < N + 1; i++) set[i] = i;
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) merge(i, j);
			}
		}
		
		int[] path = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) path[i] = Integer.parseInt(st.nextToken());
		
		boolean isCorrect = true;
		for(int i = 0; i < M - 1; i++) {
			if(find(set[path[i]]) != find(set[path[i + 1]])) {
				isCorrect = false;
				
				break;
			}
		}
		
		System.out.println(isCorrect ? "YES" : "NO");
	}
	
	private static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		set[u] = v;
	}
	
	private static int find(int u) {
		if(u == set[u]) {
			return u;
		}
		
		return set[u] = find(set[u]);
	}
}