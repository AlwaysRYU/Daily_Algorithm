package M09;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test용 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = "ABCDEF";
		ArrayList<Character> list = new ArrayList<>();
		
		for (int i = 0; i < x.length(); i++) {
			list.add(x.charAt(i));
		}
		for(char xx : list) {
			System.out.print(xx);
		}
		System.out.println();
		
		list.add(0,'O');
		list.add(5, 'X');
		list.remove(5);
		
		for(char xx : list) {
			System.out.print(xx);
		}
		
	
	}

}
