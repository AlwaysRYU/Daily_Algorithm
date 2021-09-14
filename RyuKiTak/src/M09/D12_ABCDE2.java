package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13023
public class D12_ABCDE2 {
	static int N, M;
	static boolean answer = false;
	static boolean[][] friend;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		friend = new boolean[N][N];
		check = new boolean[N];
		
		ArrayList<Integer> Nodelist = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			friend[A][B] = true;
			friend[B][A] = true;
			if ( !Nodelist.contains(A) ) Nodelist.add(A);
			if ( !Nodelist.contains(B) ) Nodelist.add(B);
			
			
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(friend[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < N; i++) {
			check[i] = true;
			countFriends(0, i, Nodelist);
			check[i] = false;
			if (answer) break;
		}
		
		if (answer) System.out.println(1);
		else System.out.println(0);
	}

	static void countFriends(int count, int now, ArrayList<Integer> Nodelist) {
		if (answer) return;
		if (count == 4) {
//			System.out.println("친구 5명 선긋기 가능");
			answer = true;
			return;
		}
		for (int i = 0; i < Nodelist.size(); i++) {
			int number = Nodelist.get(i);
			if ( check[number] ) continue;
			if (!friend[now][number]) continue;
			check[number] = true;
			countFriends(count +1 , number, Nodelist);
			check[number] = false;
		}
		
//		for (int i = 0; i < N; i++) {
//			if ( check[i] ) continue;
//			if (!friend[now][i]) continue;
//			check[i] = true;
//			countFriends(count +1 , i, Nodelist);
//			check[i] = false;
//		}
		
	}
}
