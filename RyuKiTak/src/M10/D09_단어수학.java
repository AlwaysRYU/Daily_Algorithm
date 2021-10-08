package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D09_단어수학 {
	static int AN, N;
	static int[] alphabet = new int[26];
	static int[] number = new int[20];
	static boolean[] visit = new boolean[20];
	static ArrayList<Integer> nowAlpha;
	static int[] select;
	static int answer;
	
	static String[] mun;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 10; i++) {
			number[i] = i;
			number[i+10] = i;
		}
		System.out.println(Arrays.toString(number));
		System.out.println();
		for (int i = 0; i < 26; i++) {
			alphabet[i] = -2;
		}
		
		answer = 0;
		N = Integer.parseInt(br.readLine());
		nowAlpha = new ArrayList<>();
		mun = new String[N];
		
		AN = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			mun[i] = str;
			for (int j = 0; j < str.length(); j++) {
				int temp = str.charAt(j) - 'A';
				if (alphabet[temp] == -2) {
					alphabet[temp] = -1;	
					nowAlpha.add(temp);
					AN += 1;
				}
			}
		}
		
		System.out.println("들어있는 알파뱃");
		for(int x : nowAlpha) {
			System.out.print(x + " ");
		}
		System.out.println();
		// 현재 alphabet 의 값은 -1 이다.
		
		// 총숫자 0 0 1 1 2 2 3 3  44 55 66 77 88 99 20개중
		// 알파뱃개수만큼 뽑아내면
		select = new int[AN];
		setnumber(0, 0);
		System.out.println(answer);
		
	}
	
	static void setnumber(int index, int depth) {
		if (depth == AN) {
			System.out.println(Arrays.toString(select));
			// 배열완성
			for (int i = 0; i < AN; i++) {
				int nowA = nowAlpha.get(i);
				alphabet[nowA] = select[i];
			}
			
			
			// 문장 실행
			int total = 0;
			for (int i = 0; i < N; i++) {
				String temp = mun[i];
				int ten = 1;
				for (int j = temp.length()-1; j >= 0; j--) {
					int now = temp.charAt(j) - 'A';
					total += alphabet[now] * ten;
					ten *= 10;
				}
			}
			
			if (total> answer) {
				answer = total;
//				System.out.println(Arrays.toString(alphabet));
			}
			return;
		}
		
		if (index == 20) return;
		
		select[depth] = number[index];
		setnumber(index + 1, depth +1);
		setnumber(index+1, depth);
		
	}

}
