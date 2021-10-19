import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_유기농배추{

	static int K;
	static boolean[][] MAP;
	static int[][] P;
	static int[][] cross= {{1, 0}, {-1, 0}, {0, 1}, {0 ,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			MAP = new boolean[M+2][N+2];
			P = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken())+1, Y = Integer.parseInt(st.nextToken())+1;
				MAP[X][Y] = true;
				P[i][0] = X;
				P[i][1] = Y;
			}
			int count = 0;
			for (int i = 0; i < K; i++) {
				if(MAP[P[i][0]][P[i][1]]) {
					count++;
					crossSearch(P[i]);
				}
			}
			System.out.println(count);
		}
	}
	
	static void crossSearch(int[] point) {
		if(!MAP[point[0]][point[1]]) return;
		MAP[point[0]][point[1]] = false;
		for (int i = 0; i < 4; i++) {
			int[] tmp = new int[2];
			tmp[0] = point[0]+cross[i][0];
			tmp[1] = point[1]+cross[i][1];
			if(MAP[tmp[0]][tmp[1]]) crossSearch(tmp);
		}
	}

}