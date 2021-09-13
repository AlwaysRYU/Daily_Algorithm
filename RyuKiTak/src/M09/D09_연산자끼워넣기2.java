package M09;

// https://www.acmicpc.net/problem/15658
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 시간초과
public class D09_연산자끼워넣기2 {
	// 1과의 차이는 N-1보다 많을 수 도 있는 것이다. 
	static int Maxx = Integer.MIN_VALUE;
	static int Minn = Integer.MAX_VALUE;
	static boolean[] check;
	static int[] arr;
	static int[] giho;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 숫자 개수
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		// 숫자 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 기호 받기
		st = new StringTokenizer(br.readLine());
		giho = new int[4];
		int gihosum = 0;
		// + - X / 0 1 2 3 
		for (int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			giho[i] = temp;
		}
		
		
		// ㄱㄱ
		
		dfs(N-1, 1, arr[0], giho);
		
		System.out.println(Maxx);
		System.out.println(Minn);
	}
	
	static void dfs(int total, int count, int sum, int[] giho ) {
		
		if ( count > total ) {
			Maxx = Integer.max(sum, Maxx);
			Minn = Integer.min(sum, Minn);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (giho[i] == 0) continue;
			giho[i] -= 1;
			if (i== 0) {
				dfs(total, count+1, sum + arr[count] ,giho );
			} else if ( i == 1) {
				dfs(total, count+1, sum - arr[count] ,giho );
			} else if ( i == 2) {
				dfs(total, count+1, sum * arr[count]  ,giho );
			} else if ( i == 3) {
				dfs(total, count+1, sum / arr[count] ,giho );
			}
			giho[i] += 1;			
		}
		
		
	}

}