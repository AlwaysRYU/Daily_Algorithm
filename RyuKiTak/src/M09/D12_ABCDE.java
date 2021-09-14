package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13023
public class D12_ABCDE {
	static int N, M;
	static boolean answer = false;
//	static boolean[][] friend;
	static boolean[] check;
	static ArrayList<Integer>[] friend;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		friend = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friend[i] = new ArrayList<>();
		}
		check = new boolean[N];
		
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			friend[A].add(B);
			friend[B].add(A);
		}
		
		for (int i = 0; i < N; i++) {
			check[i] = true;
			countFriends(0, i);
			check[i] = false;
			if (answer) break;
		}
		
		if (answer) System.out.println(1);
		else System.out.println(0);
	}

	static void countFriends(int count, int now) {
		if (answer) return;
		if (count == 4) {
//			System.out.println("친구 5명 선긋기 가능");
			answer = true;
			return;
		}
		
		for (int i = 0; i < friend[now].size(); i++) {
			int number = friend[now].get(i);
			if ( check[number] ) continue;
			
			check[number] = true;
			countFriends(count +1 , number);
			check[number] = false;
		}
		
//		
//		for (int i = 0; i < N; i++) {
//			if ( check[i] ) continue;
//			if (!friend[now][i]) continue;
//			check[i] = true;
//			countFriends(count +1 , i, Nodelist);
//			check[i] = false;
//		}
		
	}
}
