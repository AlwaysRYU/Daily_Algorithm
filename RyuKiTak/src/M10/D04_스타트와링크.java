package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D04_스타트와링크 {
	static int N, team;
	static int answer = Integer.MAX_VALUE;
	static int[][] field;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		team = N/2;
		field = new int[N][N];
		// 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기화
		check = new boolean[N];
		
		// 일단 둘로 나누기 
		dedenchi(0,0);

		System.out.println(answer);
	
	}
	
	static void dedenchi(int index, int depth){
		if (depth == team) {

			System.out.println();
			System.out.println("팀완료");
			for (int i = 0; i < N; i++) {
				if(check[i]) System.out.print(i + "  ");
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				if(!check[i]) System.out.print(i + "  ");
			}
			System.out.println();
			
			score();
			return;
		}
		
		if (index == N) return;
		
		check[index] = true;
		dedenchi(index+1, depth+1);
		check[index] = false;
		dedenchi(index+1, depth);
		
	}
	
	static void score() {
		int Ateam = 0;
		int Bteam = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (check[i] && check[j]) {
					Ateam += field[i][j];
					Ateam += field[j][i];
				} else if ( !check[i] && !check[j] ) {
					Bteam += field[i][j];
					Bteam += field[j][i];
				}
			}
		}
		
		if ((Ateam - Bteam) == 0 ) {
			System.out.println(0);
			System.exit(0);
		}
		answer = Math.min(answer, Math.abs(Ateam-Bteam));
	}
	
}
