package M10;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D27_가르침_제출용 {
	static String[] array;
	static char[] alpha = new char[26];
	static boolean[] alpha_check = new boolean[26];
	static boolean[] init = new boolean[26];
	
	static int N, K;
	static int totalcount = 0;
	
	static ArrayList<Character> List;
	static char[] choose;
	
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
		List = new ArrayList<>();
		choose = new char[K];
		
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine();
			
			for (int j = 0; j < array[i].length(); j++) {
				int now = array[i].charAt(j) - 'a';
				if (alpha_check[now] ==  false ) {
					List.add(array[i].charAt(j));
					alpha_check[now] = true;
				}
			}
			
			
		}
		
//		System.out.println(List.toString());		
//		System.out.println(Arrays.toString(alpha));
//		System.out.println(Arrays.toString(alpha_check));
		
		if (K<5) {
			System.out.println(0); 
			return;
		} 
		
		comb(0,0);
		
		
		System.out.println(totalcount);
		
	}

	static void comb(int depth, int index) {
		if (depth ==  K) {
			
//			System.out.println(Arrays.toString(choose));
			if ( !init[0] || !init[8] ||!init[2] ||!init[13] ||!init[19] ) return;
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean	isok = true;
				for (int j = 0; j < array[i].length(); j++) {
					int now = array[i].charAt(j) - 'a';
					if ( init[now] == false) {
//						System.out.println(array[i] +" 의 " + array[i].charAt(j) + " <--> " + alpha[now] + " 가 없다");
						isok = false;
						break;
					}
					
				}
				if (isok) {
//					System.out.println(Arrays.toString(choose) + " 이건 오케이");
//					System.out.println(array[i] + " 이건 오케이");
					count += 1;
				}
				
			}
			
//			System.out.println("비교한다. "+ count);
			totalcount = Math.max(count,totalcount);
			return;
		}
		
		if ( index == List.size() ) {
			if (List.size() < K ) {
				if ( !init[0] || !init[8] ||!init[2] ||!init[13] ||!init[19] ) return;
				
				int count = 0;
				for (int i = 0; i < N; i++) {
					boolean	isok = true;
					for (int j = 0; j < array[i].length(); j++) {
						int now = array[i].charAt(j) - 'a';
						if ( init[now] == false) {
							
							isok = false;
							break;
						}
						
					}
					if (isok) {
						count += 1;
					}
					
				}
				totalcount = Math.max(count,totalcount);
			}
			return;
		}
		choose[depth] = List.get(index);
		
		init[List.get(index)-'a'] = true;
		comb(depth+1, index+1);
		init[List.get(index)-'a'] = false;
		comb(depth, index+1);
		
	}
	
	

}
