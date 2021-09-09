package prob_1759_암호만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L,C,mocount;
	static char[] ar;
	static boolean[] select;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//최소 1개의 모음 & 최소 2개의 자음 ==> 3개 이상
		//abc 가능 bac 불가능.(아스키 값으로 비교 가능)
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		ar = new char[C];
		select = new boolean[C];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			ar[i] = str[i].charAt(0);
		}
		Arrays.sort(ar);
			comb(0,0);
	}
	
	static void comb(int start,int cnt) {
		if(cnt==L) {
			int v = 0;
			int cc = 0;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<C;i++) {
				if(select[i]) {
					sb.append(ar[i]);
					
					if(ar[i]=='a'||ar[i]=='e'||ar[i]=='i'||ar[i]=='o'||ar[i]=='u') {
						v++;
					}else {
						cc++;
					}			
				}
			}
			if(v>=1 && cc>=2) System.out.println(sb);
		
		}
		//백트래킹
		for(int i=start;i<C;i++) {
			select[i]=true;
			comb(i+1,cnt+1);
			select[i]=false;
		}
	}
}
