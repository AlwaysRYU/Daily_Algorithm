package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D15_부등호 {
	static int N;
	static char[] kiho;
	static int[] number;
	static boolean[] visit = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		kiho = new char[N];
		number = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kiho[i] = st.nextToken().charAt(0);
		}
		
		gogo(0);
		System.out.println(maxx);
		System.out.println(minn);
		
	}

	static String minn;
	static String maxx;
	static boolean find = false;
	private static void gogo(int depth) {
		// TODO Auto-generated method stub
		if ( depth == N+1) {
			//System.out.println(Arrays.toString(number));
			if (find == false) {
				minn = "";
				for(int x : number) {
					minn += Integer.toString(x);
				}
				find = true;
			}
			
			maxx = "";
			for(int x : number) {
				maxx += Integer.toString(x);
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if ( visit[i] == false ) {
				if (depth >= 1) {
					char K = kiho[depth-1];
					if ( K == '<' ) {
						if ( number[depth-1] < i) {
							number[depth] = i;
							visit[i] = true;
							gogo(depth+1);
							visit[i] = false;
						}
					} else {
						if ( number[depth-1] > i) {
							number[depth] = i;
							visit[i] = true;
							gogo(depth+1);
							visit[i] = false;
						}
					}
				} else {
					number[depth] = i;
					visit[i] = true;
					gogo(depth+1);
					visit[i] = false;
				}
			}
				
		}
	}
	
	

}
