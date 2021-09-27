package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준광고1305 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String pattern;
		int L;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		pattern = br.readLine();

		int Pi[] = getPi(pattern);
		
		System.out.println(L-Pi[L-1]);
	}

	static int[] getPi(String Pattern) {
		int[] pi = new int[Pattern.length()];

		int j = 0;

		for (int i = 1; i < Pattern.length(); i++) {

			while (j > 0 && Pattern.charAt(i) != Pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (Pattern.charAt(i) == Pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}