package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D27_가르침 {
	static String[] array;
	static char[] alpha = new char[26];
	static boolean[] alpha_check = new boolean[26];
	static char[] choose;
	static int N, K;
	static int totalcount = 0;
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		for (int i = 0; i < 26; i++) {
			alpha[i] = (char) ('a' + i);
		}
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new String[N];
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine();
		}
		
		if (K<5) {
			System.out.println(0); 
			return;
		} 
		
		
		//
		comb(0,0);
		System.out.println(totalcount);
		
	}

	static void comb(int depth, int index) {
		if (depth == K) {
//			for (int i = 0; i < 26; i++) {
//				if (alpha_check[i]) {
//					System.out.print(alpha[i] + " ");
//				}
//			}
//			System.out.println();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < array[i].length(); j++) {
					int now = array[i].charAt(j) - 'a';
					if ( alpha_check[now] == false) return;
				}
			}
			
			totalcount += 1;
			
			return;
		}
		
		if ( index >= 26 ) return;
		alpha_check[index] = true;
		comb(depth+1, index+1);
		alpha_check[index] = false;
		comb(depth, index+1);
		
		
		
	}
	
	

}
