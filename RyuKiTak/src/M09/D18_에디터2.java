package M09;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 이것도 시간초과 난다.
public class D18_에디터2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		Stack<Character> LEFT = new Stack<>();
		Stack<Character> RIGHT = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			LEFT.push(x.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char com = st.nextToken().charAt(0);
			switch (com) {
			case 'L' :
				if(LEFT.isEmpty()) break;
				RIGHT.push(LEFT.pop());		
				break;
			case 'D' :
				if(RIGHT.isEmpty()) break;
				LEFT.push(RIGHT.pop());	
				break;
			case 'B' :
				if(LEFT.isEmpty()) break;
				LEFT.pop();
				break;
			case 'P' :
				char temp = st.nextToken().charAt(0);
				LEFT.push(temp);
				break;
			}
        }
		
		
		String answer = "";
		while(!LEFT.isEmpty()) {
			RIGHT.push(LEFT.pop());
		}
		while(!RIGHT.isEmpty()) {
			answer += RIGHT.pop().toString();
		}
		System.out.println(answer);
		
		
			
	
	}

}
