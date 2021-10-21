package temp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 업무완료하기 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer, N;
	static int[] worktime;
	static ArrayList<ArrayList<Integer>> chainwork = new ArrayList<>();;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int Test = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= Test; testcase++) {
			answer = Integer.MAX_VALUE;
			chainwork.clear();

			chainwork.add(new ArrayList<Integer>());
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				chainwork.add(new ArrayList<Integer>());
			}
			worktime = new int[N];
			
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				worktime[i] = Integer.parseInt(temp[0]);
				for (int j = 1; j < temp.length; j++) {
					int before = Integer.parseInt(temp[j]);
					chainwork.get(before).add(i);
				}
			}
			
			
			for (int i = 0; i <N; i++) {
				int[] tempT = worktime.clone();
				int tempanswer = 0;
				// 매번 반쪽고민하면서
				tempT[i] /= 2;
				for (int j = 0; j < N; j++) {
					tempanswer = Math.max(tempT[j],tempanswer);
				}
				
				answer = Math.min(answer, tempanswer);
			}
			
			bw.append("#" + testcase + " " + answer + "\n");

		}

		bw.flush();
		br.close();
		bw.close();

	}

}
