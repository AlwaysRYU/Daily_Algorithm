package algoMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicFileChooserUI;

public class swea_1245균형점 {
	static int n = 0;
	static double[] px = new double[10];
	static int[] m = new int[10];

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				px[i] = Integer.parseInt(st.nextToken()); // x좌표
			}
			for (int i = 0; i < n; i++) {
				m[i] = Integer.parseInt(st.nextToken()); // 질량
			}

			System.out.printf("#%d ", test_case);
			for (int i = 0; i < n - 1; i++) {
				binarySearch(i, px[i], px[i + 1]);
			}

			System.out.println();
		}
	}

	private static void binarySearch(int num, double l, double r) {
		// TODO Auto-generated method stub
		double x=0;
		for (int cut = 0; cut < 101; cut++) {

			x = (l + r) / 2;

			double sum1 = 0;
			double sum2 = 0;
			for (int i = 0; i <= num; i++) {
				sum1 += m[num] / (Math.sqrt(x - px[i]));
			}
			for (int i = num + 1; i < 10; i++) {
				sum1 += m[num] / (Math.sqrt(x - px[i]));
			}

			if (sum1 > sum2)
				l = x;
			else
				r = x;

		}
		System.out.printf("%.10f ", x);

	}

	static int pint(String s) {
		return Integer.parseInt(s);
	}
}