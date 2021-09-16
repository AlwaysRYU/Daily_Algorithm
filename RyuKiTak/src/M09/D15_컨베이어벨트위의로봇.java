package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/20055
public class D15_컨베이어벨트위의로봇 {
	
	static class Robot{
		int index;
		public Robot(int index) {
			this.index = index;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] belt = new int[N *2][2];

		int zerocount = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			belt[i][0] = Integer.parseInt(st.nextToken());
			if (belt[i][0] == 0 ) zerocount += 1;
			belt[i][1] = 0;
		}
		
		for (int i = 0; i < belt.length; i++) {
			System.out.print("[" + belt[i][0] + " / " + belt[i][1] + "]");
		}
		System.out.println();
		
		ArrayList<Robot> robotlist = new ArrayList<>();
		int time = 0;
		while(true) {
			time += 1;
			// 1. 한칸회전하기
			int lastN = belt[N*2 -1][0];
			int lastR = belt[N*2-1][1];
			for (int i = 1; i < 2*N; i++) {
				belt[i][0] = belt[i-1][0];
				belt[i][1] = belt[i-1][1];
			}
			belt[0][0] = lastN;
			belt[0][1] = lastR;
			
			for (int i = 0; i < belt.length; i++) {
				System.out.print("[" + belt[i][0] + " / " + belt[i][1] + "]");
			}
			System.out.println("회전함");
			
			// 2. 가장 먼저 벨트에 올라간 로봇 부터, 이동하면 이동한다.
			for (int i = 0; i < robotlist.size(); i++) {
				Robot now = robotlist.get(i);
				// 다음 칸에 로봇이 없고  AND 내구도가 1이상
				if ( now.index == 2*N-1 ) {
					if ( belt[0][1] == 0 && belt[0][0] >= 1) {
						belt[0][0] -= 1; //내구도 감소
						if(belt[0][0] == 0 ) zerocount += 1;
						belt[0][1] = 1;//로봇올림
						robotlist.get(i).index = 0; // 주소 바꿔주기
					}
				} else {
					if ( belt[now.index + 1][1] == 0 && belt[now.index + 1][0] >= 1) {
						belt[now.index + 1][0] -= 1; //내구도 감소
						if(belt[0][0] == 0 ) zerocount += 1;
						belt[now.index + 1][1] = 1;//로봇올림
						robotlist.get(i).index += 1; // 주소 바꿔주기
					}
				}
			}
			
			// 3. 올리는 위치에 내구도가 0 이아니라면 로봇 올리기
			if (belt[0][1] == 0 && belt[0][0] >= 1) {
				belt[0][0] -= 1; //내구도 감소
				if(belt[0][0] == 0 ) zerocount += 1;
				belt[0][1] = 1;//로봇올림
				robotlist.add(new Robot(0));
			}
			
					
			if ( zerocount >= K) break;
		}
		System.out.println(time);
		
		
	}

}
