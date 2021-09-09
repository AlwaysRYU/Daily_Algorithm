package prob_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//수 n개, 연산자 n-1개
	//주어진 수의 순서는 안바뀜
	//같은 것이 있는 순열의 개수 = (전체 가짓수)! / (특정 원소의 수)! * (다른 특정 원소의 수)!....
	
	static int N,calsize,sum;
	static int[] ar,cal;
	static char[] cal_2,cal_tgt;
	static boolean[] select;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//우선순위를 무시하고 앞에서부터 진행
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		cal = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
			//cal[0] : 덧셈 개수 , cal[1] : 뺄셈 개수, cal[2] : 곱셈 개수, cal[3] : 나눗셈 개수
			calsize += cal[i];
		}
		int cnt = 0;
		sum = ar[0];
		cal_2 = cal_tgt = new char[calsize]; //주어진 배열
		select = new boolean[calsize];
		for (int i = 0; i < 4; i++) {
			while(cal[i] > 0) {
				
				if(i == 0)	cal_2[cnt] = '+';
				else if(i == 1)	cal_2[cnt] = '-';
				else if(i == 2) cal_2[cnt] = '*';
				else if(i == 3) cal_2[cnt] = '/';
				cal[i]--;
				cnt++;
			}
		}
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == calsize) {
			for (int i = 0; i < calsize; i++) {
					switch(cal_tgt[i]) {
					case '+' :
						sum += ar[i+1];
						break;
					case '-' :
						sum -= ar[i+1];
						break;
					case '*' :
						sum *= ar[i+1];
						break;
					case '/' :
						sum /= ar[i+1];
						break;
					}
				}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			sum = ar[0];
			return;
			}
			//src로부터 모든 수를 고려. 단 기존에 선택된 숫자는 제외
			for (int i = 0; i < calsize; i++) {
				if(select[i]) continue;
				
				cal_tgt[tgtIdx] = cal_2[i];
				select[i] = true;
				perm(tgtIdx +1);
				select[i] = false;
			}
	}
}
